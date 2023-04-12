package no.hvl.dat109.model;

import java.util.ArrayList;
import java.util.Random;


public class Terning {

//    brukes av Kast-klassen

    private int verdi;
    private int terningNr;
    private boolean behold;

    public Terning(int verdi, int terningNr) {
        this.verdi = verdi;
        this.terningNr = terningNr;
        behold = false;
    }

    /**
     * Triller en terning og gir en ny verdi til terningen
     */
    public void trill() {
        verdi= (int) (Math.random() * (6 - 1)) + 1;
    }

    /**
     * @return verdien på terningen
     */
    public int getVerdi() {
        return verdi;
    }
    public void setVerdi(int verdi){
        this.verdi = verdi;
    }
    public boolean isBehold() {
        return behold;
    }

    public void setBehold(boolean behold) {
        this.behold = behold;
    }

    public int getTerningNr() {
        return terningNr;
    }

    @Override
    public String toString() {
        return "Terning{" +
                "verdi=" + verdi +
                ", terningNr=" + terningNr +
                ", behold=" + behold +
                '}';
    }
}

