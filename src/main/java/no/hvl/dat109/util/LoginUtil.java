package no.hvl.dat109.util;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;

import no.hvl.dat109.model.Bruker;

public class LoginUtil {
	
	private final static int MAX_INTERACTIVE_INTERVAL = 60;

	public static void loggUtBruker(HttpSession session) {
        session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, Bruker bruker) {
    	
        loggUtBruker(request.getSession());

        
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("bruker", bruker);
        session.setAttribute("brukernavn", bruker.getBrukernavn());
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null && session.getAttribute("bruker") != null;
	}

}
