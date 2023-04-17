package no.hvl.dat109.controllerSpill;




import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.model.Bruker;
import no.hvl.dat109.model.Spill;
import no.hvl.dat109.model.Spilldeltakelse;
import no.hvl.dat109.service.TestSpillService;
import no.hvl.dat109.util.LoginUtil;



@Controller
@RequestMapping("/${app.url.spillside}")
public class lagEllerJoinSpillController {
	
	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.hovedside}") private String HOVEDSIDE_URL;
	@Value("${app.url.minside}") private String MINSIDE_URL;
	@Value("${app.url.spillet}") private String SPILL_URL;
	@Value("${app.url.joinspill}") private String JOINSPILL_URL;
	@Value("${app.url.spillside}") private String SPILLSIDE_URL;

	@Autowired 
	TestSpillService tss;
	
	@GetMapping
    public String doGet(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		return "lagspillView";
    }

	@PostMapping
    public String doPost(@RequestParam String valg,
    		HttpServletRequest request,	RedirectAttributes ra, HttpSession session) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		if(valg.equals("nytt spill")) {
			
			Spill spill = tss.lagSpill1("A");
			session.setAttribute("spill", spill);
			Bruker bruker = (Bruker) session.getAttribute("bruker");
			
			Spilldeltakelse spillDeltakelse = tss.lagSpillDeltakelse1(bruker.getBrukernavn(), spill.getSpillid());
			session.setAttribute("spilldeltakelse", spillDeltakelse);
			
			return "redirect:" + SPILL_URL;
			
		} else if(valg.equals("join spill")) {
			return "redirect:" + JOINSPILL_URL;
		} else {
			return "redirect:" + SPILLSIDE_URL;
		}
			
	}
}