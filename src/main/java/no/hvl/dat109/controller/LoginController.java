package no.hvl.dat109.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.model.Bruker;
import no.hvl.dat109.repo.BrukerRepo;
import no.hvl.dat109.service.TestSpillService;
import no.hvl.dat109.util.InputValidator;
import no.hvl.dat109.util.LoginUtil;
import no.hvl.dat109.util.PassordUtil;

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {
	
	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.startside}") private String STARTSIDE_URL;
	@Value("${app.url.hovedside}") private String HOVEDSIDE_URL;
	
	@Autowired  
	BrukerRepo brukerepo;
	@Autowired
	TestSpillService testSpill;
	
	@GetMapping
    public String hentLoginSkjema() {
		return "loginView";
    }

	
	@PostMapping
    public String provAaLoggeInn(@RequestParam String brukernavn, @RequestParam String passord,
    		HttpServletRequest request,	RedirectAttributes ra) {
		
		Bruker bruker = testSpill.hentBruker(brukernavn);
			
		if(!PassordUtil.validerMedSalt(passord, bruker.getSalt(), bruker.getPassordhash())) {
			ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		if(!InputValidator.brukerEksisterer(bruker)) {
			ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}

		LoginUtil.loggInnBruker(request, bruker);

		return "redirect:" + HOVEDSIDE_URL;
    }
}
