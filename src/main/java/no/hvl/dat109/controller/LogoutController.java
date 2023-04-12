package no.hvl.dat109.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.logout}")
public class LogoutController {
	
	@Value("${app.message.loggedOut}") private String LOGGED_OUT_MESSAGE;
	@Value("${app.url.login}") private String LOGIN_URL;
	@Value("${app.url.startside}") private String STARTSIDE_URL;
	
	/* 
	 * POST /logou t er forespørselen for å logge ut.
	 */
	@PostMapping
    public String loggUt(HttpSession session, RedirectAttributes ra) {
		
		if (LoginUtil.erBrukerInnlogget(session)) {
			LoginUtil.loggUtBruker(session);
		}
   	
		ra.addFlashAttribute("redirectMessage", LOGGED_OUT_MESSAGE);
		return "redirect:" + STARTSIDE_URL;
    }
}
