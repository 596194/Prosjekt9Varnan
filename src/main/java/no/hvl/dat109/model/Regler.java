package no.hvl.dat109.model;

import java.util.*;
import java.util.stream.Collectors;

public class Regler {





    public static int enere(ArrayList<Terning> terninger) {
        return vanligeTall(terninger, 1);
    }

    public static int toere(ArrayList<Terning> terninger) {
        return vanligeTall(terninger, 2);
    }

    public static int treere(ArrayList<Terning> terninger) {
        return vanligeTall(terninger, 3);
    }

    public static int firere(ArrayList<Terning> terninger) {
        return vanligeTall(terninger, 4);
    }

    public static int femmere(ArrayList<Terning> terninger) {
        return vanligeTall(terninger, 5);
    }

    public static int seksere(ArrayList<Terning> terninger) {
        return vanligeTall(terninger, 6);
    }

    /**
     * @param terninger
     * @return summen av det høyeste paret
     */
    public static int ettPar(ArrayList<Terning> terninger) {
        int par = 0;
//        List<Terning> terninger =kast.getTerninger();
        Map<Integer, Long> verdiMap = map(terninger);

        for (int verdi = 6; verdi >= 1; verdi--) {
            long antall = verdiMap.getOrDefault(verdi, 0L);
            if (antall >= 2) {
                par = verdi * 2;
                break;
            }
        }
        return par;
    }

    public static int toPar(ArrayList<Terning> terninger) {
        int sum=0;

        Map<Integer, Long> verdiMap = map(terninger);

        List<Integer> toPar = verdiMap.keySet().stream()
                .filter(key -> verdiMap.get(key) >= 2L)
                .toList();

        if (toPar.size() == 2) {
            sum = toPar.get(0) * 2 + toPar.get(1) * 2;
        }

        return sum;
    }


    public static int treLike(ArrayList<Terning> terninger) {
        int sum = 0;

        Map<Integer, Long> verdiMap = map(terninger);

        List<Integer> treLike = verdiMap.keySet().stream()
                .filter(key -> verdiMap.get(key) >= 3L)
                .toList();

        if(treLike.size()==1){
            sum=treLike.get(0)*3;
        }
        return sum;
    }

    public static int fireLike(ArrayList<Terning> terninger) {
        int sum = 0;

        Map<Integer, Long> verdiMap = map(terninger);

        List<Integer> fireLike = verdiMap.keySet().stream()
                .filter(key -> verdiMap.get(key) >= 4L)
                .toList();

        if(fireLike.size()==1){
            sum=fireLike.get(0)*4;
        }

        return sum;
    }

    public static int litenStraight(ArrayList<Terning> terninger) {
        int sum=0;

        Map<Integer, Long> verdiMap = map(terninger);

        if((verdiMap.size() == 5) && !(verdiMap.containsKey(6))){
            sum=terninger.stream()
                    .mapToInt(Terning::getVerdi).sum();
        }
        return sum;
    }

    public static int storStraight(ArrayList<Terning> terninger) {
        int sum=0;

        Map<Integer, Long> verdiMap = map(terninger);

        if((verdiMap.size() == 5) && !(verdiMap.containsKey(1))){
            sum=terninger.stream()
                    .mapToInt(Terning::getVerdi).sum();
        }
        return sum;
    }

    public static int hus(ArrayList<Terning> terninger) {
        int sum=0;

        Map<Integer, Long> verdiMap = map(terninger);

        if((verdiMap.size() == 2) && (verdiMap.containsValue((long) 2))){
            sum=terninger.stream()
                    .mapToInt(Terning::getVerdi).sum();
        }
        return sum;
    }

    public static int sjanse(ArrayList<Terning> terninger) {
        int sum = terninger.stream().mapToInt(Terning::getVerdi).sum();

        return sum;
    }

    public static int yatzy(ArrayList<Terning> terninger) {
        int sum =0;
        boolean likeTerninger =terninger.stream()
                .map(Terning::getVerdi)
                .distinct()
                .count() == 1;
        if(likeTerninger){
            sum =50;
        }
        return sum;
    }
    /**
     * summerer terninger av typen tall fra et kast
     * @param terninger, tall
     * @return sum
     */
    public static int vanligeTall(ArrayList<Terning> terninger, int tall) {
        int sum = (int) terninger.stream()
                .filter(terning -> terning.getVerdi() == tall)
                .count();
        return sum * tall;
    }

    //    hjelpemetode for å holde ting mer ryddig
    //    Integer er tallverdien fra terningene
    //    Long er antallet forekomster av den verdien blant alle terningene
    private static Map<Integer, Long> map(ArrayList<Terning> terninger){
        return terninger.stream()
                .collect(Collectors.groupingBy(Terning::getVerdi,Collectors.counting()));
    }



}
