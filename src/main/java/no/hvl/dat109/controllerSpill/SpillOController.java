package no.hvl.dat109.controllerSpill;


import no.hvl.dat109.model.Spill;
import no.hvl.dat109.model.Spilldeltakelse;
import no.hvl.dat109.service.TestSpillService;
import no.hvl.dat109.services.SpilltestService;
import no.hvl.dat109.util.LoginUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/${app.url.spillet}")
public class SpillOController {

	@Autowired
	SpilltestService spilltestService;

	@Value("${app.url.spillet}")private String SPILL_URL;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	private String FERDIG="spillet er ferdig";
	private String RUNDE_ER_IKKE_FERDIG="alle har ikke ennå spilt sin runde";

		@Autowired
		TestSpillService testSpill;
		
	@GetMapping
	public String doGet(HttpServletRequest request,	RedirectAttributes ra, HttpSession session,
			@RequestParam(name="spillere", required=false) List<Spilldeltakelse> sd) {

		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}	
	
		Spill spill = (Spill) session.getAttribute("spill");
		
		sd = testSpill.hentSpillDeltakelserForSpill(spill);
		session.setAttribute("spillere", sd);
		session.setAttribute("size", sd.size());
		Spilldeltakelse spillDeltakelse = (Spilldeltakelse) session.getAttribute("spilldeltakelse");
		
		int rundenr= spill.getRunde();
		
		session.setAttribute("runde", rundenr);
		
		if(rundenr==0) {
			rundenr = testSpill.okNyrunde(spill);
		}
		if(testSpill.harAlleSpiltSinTur(sd)) {
			rundenr = testSpill.okNyrunde(spill, sd);
			testSpill.resetHarspilt(sd);
			if(spillDeltakelse.getHarspilt()) {
				testSpill.resetSpilt(spillDeltakelse);
			}
		} 

	
	return "spillView";
	}

	//tester for hver runde
	@PostMapping
    public String doPost(HttpServletRequest request, RedirectAttributes ra, HttpSession session) {
	
	if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
	}	
		
	Spill spill = (Spill) session.getAttribute("spill");
	int rundenr = (int) session.getAttribute("runde");
	System.out.println(rundenr);
	@SuppressWarnings("unchecked")
	List<Spilldeltakelse> spillDeltakelser = (List<Spilldeltakelse>) session.getAttribute("spillere");	
	Spilldeltakelse spillDeltakelse = (Spilldeltakelse) session.getAttribute("spilldeltakelse");

	if(rundenr==15) {
		testSpill.ferdigSpill(spill);
		ra.addFlashAttribute("redirectMessage", FERDIG);
		return "redirect:" + SPILL_URL;
	} else {
		
		if(!spillDeltakelse.getHarspilt()) {
			testSpill.spillRunde(rundenr, spillDeltakelse);
			testSpill.harSpiltTur(spillDeltakelse);
		} else {
			System.out.println(testSpill.harAlleSpiltSinTur(spillDeltakelser));
			ra.addFlashAttribute("redirectMessage", RUNDE_ER_IKKE_FERDIG);
			return "redirect:" + SPILL_URL;
			}	
	}
	
	return "redirect:" + SPILL_URL;
    }
	
}
