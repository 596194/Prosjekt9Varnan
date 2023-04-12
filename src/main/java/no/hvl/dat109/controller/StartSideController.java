package no.hvl.dat109.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/${app.url.startside}")
public class StartSideController {
	
	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.startside}") private String STARTSIDE_URL;
	@Value("${app.url.nybruker}") private String NYBRUKER_URL;	

	@GetMapping
    public String doGet() {
		return "startSideView";
    }

	@PostMapping
    public String doPost(@RequestParam String bruker,
    		HttpServletRequest request,	RedirectAttributes ra) {
		
		if(bruker.equals("logg inn")) {
			return "redirect:" + LOGIN_URL;
		} else if (bruker.equals("lag bruker")){
			return "redirect:" + NYBRUKER_URL;
		}
		
		return "redirect:" + STARTSIDE_URL;
    }
}