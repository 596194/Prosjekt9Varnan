package no.hvl.dat109.yatzy;


import no.hvl.dat109.model.Regler;
import no.hvl.dat109.model.Terning;
import org.testng.annotations.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRegler {
    ArrayList<Terning> terninger = new ArrayList<>();

    @Test
    public void enTilSeks(){
        terninger.add(new Terning(1,1));
        terninger.add(new Terning(2,2));
        terninger.add(new Terning(3,3));
        terninger.add(new Terning(4,4));
        terninger.add(new Terning(5,5));
        assertEquals(1, Regler.enere(terninger));
        assertEquals(2,Regler.toere(terninger));
        assertEquals(3,Regler.treere(terninger));
        assertEquals(4,Regler.firere(terninger));
        assertEquals(5,Regler.femmere(terninger));
        assertEquals(0,Regler.seksere(terninger));

        terninger.get(1).setVerdi(1);
        terninger.get(4).setVerdi(1);
        assertEquals(3,Regler.enere(terninger));
    }
    @Test
    public void etPar(){
        terninger.add(new Terning(1,1));
        terninger.add(new Terning(6,2));
        terninger.add(new Terning(3,3));
        terninger.add(new Terning(4,4));
        terninger.add(new Terning(5,5));
        assertEquals(0,Regler.ettPar(terninger));
        terninger.get(0).setVerdi(6);
        terninger.get(3).setVerdi(5);
        assertEquals(12,Regler.ettPar(terninger));
    }
    @Test
    public void toPar(){
        terninger.add(new Terning(1,1));
        terninger.add(new Terning(1,2));
        terninger.add(new Terning(1,3));
        terninger.add(new Terning(1,4));
        terninger.add(new Terning(3,5));
        assertEquals(0,Regler.toPar(terninger));
        terninger.get(0).setVerdi(3);
        assertEquals(8,Regler.toPar(terninger));
    }
    @Test
    public void treLike(){
        terninger.add(new Terning(1,1));
        terninger.add(new Terning(3,2));
        terninger.add(new Terning(3,3));
        terninger.add(new Terning(4,4));
        terninger.add(new Terning(3,5));
        assertEquals(9,Regler.treLike(terninger));
    }
    @Test
    public void fireLike(){
        terninger.add(new Terning(4,1));
        terninger.add(new Terning(4,2));
        terninger.add(new Terning(1,3));
        terninger.add(new Terning(4,4));
        terninger.add(new Terning(4,5));
        assertEquals(16,Regler.fireLike(terninger));
    }
    @Test
    public void litenStraight(){
        terninger.add(new Terning(4,1));
        terninger.add(new Terning(3,2));
        terninger.add(new Terning(1,3));
        terninger.add(new Terning(2,4));
        terninger.add(new Terning(5,5));
        assertEquals(15,Regler.litenStraight(terninger));
    }
    @Test
    public void storStraight(){
        terninger.add(new Terning(4,1));
        terninger.add(new Terning(3,2));
        terninger.add(new Terning(6,3));
        terninger.add(new Terning(2,4));
        terninger.add(new Terning(5,5));
        assertEquals(20,Regler.storStraight(terninger));
    }
    @Test
    public void hus(){
        terninger.add(new Terning(2,1));
        terninger.add(new Terning(2,2));
        terninger.add(new Terning(1,3));
        terninger.add(new Terning(1,4));
        terninger.add(new Terning(1,5));
        assertEquals(7,Regler.hus(terninger));
    }

    @Test
    public void sjanse(){
        terninger.add(new Terning(6,1));
        terninger.add(new Terning(6,2));
        terninger.add(new Terning(3,3));
        terninger.add(new Terning(4,4));
        terninger.add(new Terning(3,5));
        assertEquals(22,Regler.sjanse(terninger));
    }
    @Test
    public void yatzy(){
        terninger.add(new Terning(6,1));
        terninger.add(new Terning(6,2));
        terninger.add(new Terning(6,3));
        terninger.add(new Terning(6,4));
        terninger.add(new Terning(6,5));
        assertEquals(50,Regler.yatzy(terninger));
        terninger.get(0).setVerdi(4);
        assertEquals(0,Regler.yatzy(terninger));
    }


}
