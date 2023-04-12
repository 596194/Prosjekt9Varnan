package no.hvl.dat109.controller;

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
import no.hvl.dat109.repo.BrukerRepo;
import no.hvl.dat109.util.InputValidator;
import no.hvl.dat109.util.LoginUtil;


//test for commit 

@Controller
@RequestMapping("/${app.url.bekreftelse}")
public class BrukerRegistreringBekreftelseController {

	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.startside}") private String STARTSIDE_URL;
	@Value("${app.url.hovedside}") private String HOVEDSIDE_URL;
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	
	@Autowired 
	BrukerRepo brukerepo;
	
	@GetMapping
    public String DoPost(HttpSession session, RedirectAttributes ra) {
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		return "RegistreringBekreftelseView";
    }

	
	@PostMapping
    public String Doget(HttpServletRequest request,	RedirectAttributes ra, HttpSession session) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		return "redirect:" + HOVEDSIDE_URL;
    }
	
}
