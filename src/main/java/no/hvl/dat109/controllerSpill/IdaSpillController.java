package no.hvl.dat109.controllerSpill;

import no.hvl.dat109.model.Spill;
import no.hvl.dat109.model.Spilldeltakelse;
import no.hvl.dat109.service.TestSpillService;
import no.hvl.dat109.services.SpilltestService;

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
@RequestMapping("/${app.url.ida}")
public class IdaSpillController {

	@Autowired
	SpilltestService spilltestService;

	@Value("${app.url.ida}")private String SPILL_URL;
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
	s.setAttribute("Ida", testSpill.hentSpillDeltakelse(1, testSpill.hentBruker("Ida").getBrukerid()));
	
	return "spillIda";
	}

	//tester for hver runde
	@PostMapping
    public String doPost(HttpServletRequest request, RedirectAttributes ra, HttpSession session) {
	
	Spill spill = (Spill) session.getAttribute("spill");
	int rundenr = spill.getRunde();
	System.out.println(rundenr);
	@SuppressWarnings("unchecked")
	List<Spilldeltakelse> spillDeltakelser = (List<Spilldeltakelse>) session.getAttribute("spillere");	
	Spilldeltakelse spillDeltakelse = (Spilldeltakelse) session.getAttribute("Ida");
	
	
	if(rundenr==15) {
		ra.addFlashAttribute("redirectMessage", FERDIG);
		return "redirect:" + SPILL_URL;
	} else {
		if(rundenr==0) {
			rundenr = testSpill.okNyrunde(spill);
		}
		if(testSpill.harAlleSpiltSinTur(spillDeltakelser) && (rundenr>=1)) {
			rundenr = testSpill.okNyrunde(spill, spillDeltakelser);
		} 
		else if(!spillDeltakelse.getHarspilt()) {
			testSpill.spillRunde(rundenr, spillDeltakelse);
			testSpill.harSpiltTur(spillDeltakelse);
		} else {
			ra.addFlashAttribute("redirectMessage", RUNDE_ER_IKKE_FERDIG);
			return "redirect:" + SPILL_URL;
			}	
	}
	
	return "redirect:" + SPILL_URL;
    }
	
}