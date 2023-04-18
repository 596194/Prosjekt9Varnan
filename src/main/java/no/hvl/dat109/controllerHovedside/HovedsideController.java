package no.hvl.dat109.controllerHovedside;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.util.LoginUtil;



@Controller
@RequestMapping("/${app.url.hovedside}")
public class HovedsideController {
	
	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.hovedside}") private String HOVEDSIDE_URL;
	@Value("${app.url.minside}") private String MINSIDE_URL;
	@Value("${app.url.spillside}") private String SPILLSIDE_URL;
	@Value("${app.url.aktivespill}") private String AKTIVESPILL_URL;
	@Value("${app.url.historikk}") private String HISTORIKK_URL;
	
	@GetMapping
    public String doGet(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		
		return "HovedsideView";
    }

	@PostMapping
    public String doPost(@RequestParam String valg,
    		HttpServletRequest request,	RedirectAttributes ra, HttpSession session) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}

		return switch (valg) {
			case "Min_side" -> "redirect:" + MINSIDE_URL;
			case "Spill" -> "redirect:" + SPILLSIDE_URL;
			case "Mine aktive" -> "redirect:" + AKTIVESPILL_URL;
			case "Historikk" -> "redirect:" + HISTORIKK_URL;
			default -> "redirect:" + HOVEDSIDE_URL;
		};

	}
}