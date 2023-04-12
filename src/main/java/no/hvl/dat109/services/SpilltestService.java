package no.hvl.dat109.services;

import no.hvl.dat109.model.Spilltest;
import no.hvl.dat109.model.Terning;
import no.hvl.dat109.repo.SpilltestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static no.hvl.dat109.model.Regler.*;

@Service
public class SpilltestService {
    @Autowired
    SpilltestRepo spilltestRepo;

    public List<Spilltest> finnAlle() {
        return spilltestRepo.findAll();
    }

    public List<Spilltest> finnSpillTest(Integer spillid) {
        return spilltestRepo.findAllBySpillid(spillid);
    }

    public void spillTur(int spillid, int tur, ArrayList<Terning> terninger) {
        Spilltest spilltest = spilltestRepo.findAllBySpillid(spillid).get(0);
        switch (tur) {
            case 1 -> spilltest.setEnere(enere(terninger));
            case 2 -> spilltest.setToere(toere(terninger));
            case 3 -> spilltest.setTreere(treere(terninger));
            case 4 -> spilltest.setFirere(firere(terninger));
            case 5 -> spilltest.setFemmere(femmere(terninger));
            case 6 -> spilltest.setSeksere(seksere(terninger));
            case 7 -> spilltest.setEtPar(ettPar(terninger));
            case 8 -> spilltest.setToPar(toPar(terninger));
            case 9 -> spilltest.setTreLike(treLike(terninger));
            case 10 -> spilltest.setFireLike(fireLike(terninger));
            case 11 -> spilltest.setLitenStraight(litenStraight(terninger));
            case 12 -> spilltest.setStorStraight(storStraight(terninger));
            case 13 -> spilltest.setHus(hus(terninger));
            case 14 -> spilltest.setSjanse(sjanse(terninger));
            case 15 -> spilltest.setSjanse(yatzy(terninger));
        }//end tur
        //TODO Må også øke tur med +1 for spiller.
        spilltestRepo.save(spilltest);
    }
}
