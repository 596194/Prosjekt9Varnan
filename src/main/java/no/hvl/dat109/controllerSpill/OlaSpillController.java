package no.hvl.dat109.controllerSpill;

import no.hvl.dat109.model.Bruker;
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
@RequestMapping("/${app.url.ola}")
public class OlaSpillController {

	@Autowired
	SpilltestService spilltestService;

	@Value("${app.url.ola}")private String SPILL_URL;
	private String FERDIG="spillet er ferdig";
	private String RUNDE_ER_IKKE_FERDIG="alle har ikke ennå spilt sin runde";

		@Autowired
		TestSpillService testSpill;
		
	@GetMapping
	public String doGet(HttpServletRequest request,	RedirectAttributes ra, HttpSession session,
			@RequestParam(name="spillere", required=false) List<Spilldeltakelse> sd) {
	
	testSpill.lagTestSpill();
		
	HttpSession s = request.getSession();
	
	session.setMaxInactiveInterval(60);

	
	sd = testSpill.hentSpillDeltakelserForSpill(testSpill.hentSpill(1));
	s.setAttribute("spillere", sd);
	s.setAttribute("size", sd.size());
	s.setAttribute("spill", testSpill.hentSpill(1)); 
	s.setAttribute("Ola", testSpill.hentSpillDeltakelse(1,testSpill.hentBruker("Ola").getBrukerid()));

	
	return "spillOla";
	}

	//tester for hver runde
	@PostMapping
    public String doPost(HttpServletRequest request, RedirectAttributes ra, HttpSession session) {
	
	Spill spill = (Spill) session.getAttribute("spill");
	int rundenr = spill.getRunde();
	System.out.println(rundenr);
	@SuppressWarnings("unchecked")
	List<Spilldeltakelse> spillDeltakelser = (List<Spilldeltakelse>) session.getAttribute("spillere");	
	Spilldeltakelse spillDeltakelse = (Spilldeltakelse) session.getAttribute("Ola");
	
	
	if(rundenr==15) {
		ra.addFlashAttribute("redirectMessage", FERDIG);
		return "redirect:" + SPILL_URL;
	} else {
		if(rundenr==0) {
			rundenr = testSpill.okNyrunde(spill);
		}
		else if(testSpill.harAlleSpiltSinTur(spillDeltakelser)) {
			rundenr = testSpill.okNyrunde(spill, spillDeltakelser);
		} 
		else if(!spillDeltakelse.getHarspilt()) {
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
	