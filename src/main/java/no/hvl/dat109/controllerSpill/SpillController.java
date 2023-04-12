package no.hvl.dat109.controllerSpill;

import no.hvl.dat109.model.Spill;
import no.hvl.dat109.model.Spilldeltakelse;
import no.hvl.dat109.service.TestSpillService;
import no.hvl.dat109.services.SpilltestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;






@Controller
@RequestMapping("/${app.url.spill}")
public class SpillController {

	@Autowired
	SpilltestService spilltestService;

	@Value("${app.url.spill}")private String SPILL_URL;
	private String FERDIG="spillet er ferdig";

		@Autowired
		TestSpillService testSpill;
		
	@GetMapping
	public String doGet(HttpServletRequest request,	RedirectAttributes ra, HttpSession session,
			@RequestParam(name="spillere", required=false) List<Spilldeltakelse> sd) {
	
	testSpill.lagTestSpill();
	
	session.invalidate();
	
	HttpSession s = request.getSession();
	
	sd = testSpill.hentSpillDeltakelserForSpill(testSpill.hentSpill(1));
	s.setAttribute("spillere", sd);
	s.setAttribute("size", sd.size());
	s.setAttribute("spill", testSpill.hentSpill(1));
	session.setMaxInactiveInterval(60);
	
	return "spill";
    }

	//tester for hver runde
	@PostMapping
    public String doPost(HttpServletRequest request, RedirectAttributes ra, HttpSession session) {
	
	Spill spill = (Spill) session.getAttribute("spill");
	@SuppressWarnings("unchecked")
	List<Spilldeltakelse> spillDeltakelser = (List<Spilldeltakelse>) session.getAttribute("spillere");
	
	
	
	int rundenr = testSpill.okNyrunde(spill);
	
	if(rundenr==15) {
		//System.out.println("testing");
		ra.addFlashAttribute("redirectMessage", FERDIG);
		return "redirect:" + SPILL_URL;
	} else {
		testSpill.spillRunde(rundenr, spillDeltakelser);
	}
	
	return "redirect:" + SPILL_URL;
    }
	
	//tester alle 15 runder med engang
	/*
	@PostMapping
    public String doPost(HttpServletRequest request, RedirectAttributes ra, HttpSession session) {
	
	Spill spill = (Spill) session.getAttribute("spill");
	@SuppressWarnings("unchecked")
	List<Spilldeltakelse> spillDeltakelser = (List<Spilldeltakelse>) session.getAttribute("spillere");
		
	testSpill.TestSpill(spillDeltakelser, spill);	
		
	
	return "redirect:" + SPILL_URL;
    }
    */
}