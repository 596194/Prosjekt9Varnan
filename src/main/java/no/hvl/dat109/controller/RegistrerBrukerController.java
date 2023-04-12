package no.hvl.dat109.controller;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat109.service.TestSpillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import no.hvl.dat109.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.nybruker}")
public class RegistrerBrukerController {

    @Autowired
    TestSpillService testSpill;
    
    @Value("${app.message.invalidUsername}")
    private String INVALID_USERNAME_MESSAGE;
    @Value("${app.url.login}")
    private String LOGIN_URL;
    @Value("${app.url.startside}")
    private String STARTSIDE_URL;
    @Value("${app.url.bekreftelse}")
    private String BEKREFT_REG_URL;

    @GetMapping
    public String doGet() {
        return "RegistrerBrukerView";
    }

    @PostMapping
    public String doPost(@RequestParam String brukernavn, @RequestParam String fornavn,
                         @RequestParam String etternavn, @RequestParam String epost, @RequestParam String passord,
                         @RequestParam String repassord, HttpServletRequest request, RedirectAttributes ra) {
    	
    	testSpill.lagBruker(brukernavn, fornavn, etternavn, epost, passord);
    	
        LoginUtil.loggInnBruker(request, testSpill.hentBruker(brukernavn));

        return "redirect:" + BEKREFT_REG_URL;
    }
}