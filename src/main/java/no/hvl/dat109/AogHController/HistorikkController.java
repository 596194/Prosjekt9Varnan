package no.hvl.dat109.AogHController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

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
@RequestMapping("/${app.url.historikk}")
public class HistorikkController {
	
	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.historikk}") private String HISTORIKK_URL;


	@Autowired 
	TestSpillService tss;
	
	@GetMapping
    public String doGet(HttpSession session, RedirectAttributes ra,
    		@RequestParam(name="spillene", required=false) List<Spill> alleFerdigeSpill) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		Bruker bruker = (Bruker) session.getAttribute("bruker");
		
		alleFerdigeSpill = tss.hentAlleFerdigSpill(bruker.getBrukerid());
		session.setAttribute("spillene", alleFerdigeSpill);
		
		return "historikkView";
    }

}