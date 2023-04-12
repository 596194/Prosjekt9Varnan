package no.hvl.dat109.controller;

import jakarta.servlet.http.HttpSession;

import no.hvl.dat109.util.PassordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static no.hvl.dat109.util.PassordUtil.genererTilfeldigSalt;
import static no.hvl.dat109.util.PassordUtil.hashMedSalt;
import no.hvl.dat109.util.LoginUtil;

@Controller
public class WebController {

    @Autowired
   // private BrukerService brukerService;

    @GetMapping(value = "testavspill")
    public String testavspill() {
        return "spill";
    }

    @GetMapping(value = "lagbruker")
    public String lagBrukerView() {
        return "lagbruker";
    }


    @PostMapping(value = "lagBruker")
    public String lagBruker(Model model, @RequestParam String brukernavn, @RequestParam String fornavn, @RequestParam String etternavn, @RequestParam String epost, @RequestParam String passord, @RequestParam String repassord) {


        String salt = genererTilfeldigSalt();

        if (passord.equals(repassord)) {
            String passordHash = hashMedSalt(passord, salt);
          // brukerService.leggTilBruker(brukernavn, fornavn, etternavn, epost, salt, passordHash);
            System.err.println("Ny bruker opprettet");
            return "spill";
        }

        System.err.println("Feilet på å lage ny bruker, feil passord?");

        return "spill";

    }
    @GetMapping(value="min_side")
    public String minSideView(Model model, HttpSession httpSession){
        //model.addAttribute("bruker",brukerService.finnBrukerByBrukernavn(httpSession.getAttribute("brukernavn").toString()));

        return "min_side";
    }
    @GetMapping(value="logg_ut")
    public String loggUt(HttpSession session){
        LoginUtil.loggUtBruker(session);
        return "startSideView";
    }

}


