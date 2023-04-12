package no.hvl.dat109.model;

import java.util.ArrayList;

/*
    en spiller kaster terninger på sin tur
    velger hvilke som skal beholdes

    siste kastet registreres utfallet opp mot reglene
 */
public class Tur {

    private ArrayList<Terning> terninger = new ArrayList<>(lagTerninger());

    public Tur() {

    }
 
    
    public ArrayList<Terning> getTerninger() {
		return terninger;
	}


    /**
     * lager terningene som skal brukes på en spiller sin tur
     * @return et sett med terninger som alle har verdi 0
     * og boolean behold=false
     */
    public ArrayList<Terning> lagTerninger(){
        ArrayList<Terning> terninger = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            terninger.add(new Terning(0, i+1));
        }
        return terninger;
    }

    /**
     * triller de terningene som har behold=false
     */
    public void kast() {
        for (Terning terning : terninger) {
            if (!terning.isBehold()){
                    terning.trill();
                }

                System.out.println("Kaster terning: " + terning.getTerningNr() + ", verdi:" + terning.getVerdi());
            }
        }

    /**
     *her velger spilleren hvilke terninger som skal beholdes mellom kastene
     *      web-input
     */
    public void velg(){


        // TODO: 24-Mar-23

        settTerning123True(); //midlertidig hjelpeklasse
        System.out.println("velg() -> settTerning123True");
    }

    /**
     * registrerer resultatet fra en tur i resultatblokken
     * @param runde
     */
    public void registrer(int runde, Spilldeltakelse spillDeltakelse){

        spillDeltakelse.leggTilResultat(runde, turFerdig(terninger,runde));

        System.out.println(spillDeltakelse);
    }


    public void settTerning123True(){
        for (Terning terning : terninger) {
            if (terning.getTerningNr() == 1 || terning.getTerningNr() == 2 || terning.getTerningNr() == 3) {
                terning.setBehold(true);
            }
        }
    }
    public int turFerdig(ArrayList<Terning> terninger, int runde) {
        return switch (runde) {
            case 1 -> Regler.enere(terninger);
            case 2 -> Regler.toere(terninger);
            case 3 -> Regler.treere(terninger);
            case 4 -> Regler.firere(terninger);
            case 5 -> Regler.femmere(terninger);
            case 6 -> Regler.seksere(terninger);
            case 7 -> Regler.ettPar(terninger);
            case 8 -> Regler.toPar(terninger);
            case 9 -> Regler.treLike(terninger);
            case 10 -> Regler.fireLike(terninger);
            case 11 -> Regler.litenStraight(terninger);
            case 12 -> Regler.storStraight(terninger);
            case 13 -> Regler.hus(terninger);
            case 14 -> Regler.sjanse(terninger);
            case 15 -> Regler.yatzy(terninger);
            default -> 0;
        };
    }
}
