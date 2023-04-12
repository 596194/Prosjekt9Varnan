package no.hvl.dat109.service;

import java.util.ArrayList;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat109.model.Bruker;
import no.hvl.dat109.model.Spill;
import no.hvl.dat109.model.Spilldeltakelse;

import no.hvl.dat109.model.Tur;
import no.hvl.dat109.model.idclass.SpillDeltakelseId;
import no.hvl.dat109.repo.BrukerRepo;
import no.hvl.dat109.repo.SpillDeltakelseRepo;
import no.hvl.dat109.repo.SpillRepo;


@Service
public class TestSpillService {

	@Autowired
	BrukerRepo brukerepo;
	@Autowired	
	SpillRepo spillrepo;
	@Autowired 
	SpillDeltakelseRepo sprepo;
	
	public Bruker hentBruker(String brukernavn) {
		
		for(Bruker b: brukerepo.findAll()) {
			if(b.getBrukernavn().equals(brukernavn)) {
				return b;
			}
		}
		return null;
	}
	
	public void slettBruker(Bruker bruker) {
		brukerepo.delete(bruker);
	}
	
	public void lagBruker(String brukernavn, String fornavn,String etternavn,String epost,String passord) {
		Bruker bruker = new Bruker(brukernavn, fornavn, etternavn, epost, passord); 
		brukerepo.save(bruker);
	}
	
<<<<<<< HEAD
	public Bruker lagBrukerReturn(String brukernavn, String fornavn,String etternavn,String epost,String passord) {
=======
	public Bruker lagBrukereturn(String brukernavn, String fornavn,String etternavn,String epost,String passord) {
>>>>>>> stash
		Bruker bruker = new Bruker(brukernavn, fornavn, etternavn, epost, passord); 
		brukerepo.save(bruker);
		return bruker;
	}
	
	public void lagSpill(String status) {
		Spill spill = new Spill("A");
		spillrepo.save(spill);
	}
	
	public Spill hentSpill(Integer id) {
		return spillrepo.findById(id).orElse(null);
	}

	
	public void slettSpill(Spill spill) {
		spillrepo.delete(spill);
		
	}
	
	public void lagSpillDeltakelse(String brukernavn , Integer spillid) {
		Bruker bruker= hentBruker(brukernavn);
		Spill spill = hentSpill(spillid);
		Spilldeltakelse spilldeltakelse = new Spilldeltakelse(new SpillDeltakelseId(spill.getSpillid(), bruker.getBrukerid())
		, spill, bruker,new Integer[15]);
		sprepo.save(spilldeltakelse);
	}
	
	
	public Spilldeltakelse hentSpillDeltakelse(Integer spillid, Integer brukerid) {
		SpillDeltakelseId spillDeltakelseId = new SpillDeltakelseId(spillid, brukerid);
		return sprepo.findById(spillDeltakelseId).orElse(null);
	}
	
	public void slettSpillDeltakelse(Spilldeltakelse spilldeltakelse) {
		sprepo.delete(spilldeltakelse);
	}
	
	public void lagTestBrukere(String b1, String b2) {
		
		Bruker bruker1 = hentBruker(b1);
		Bruker bruker2 = hentBruker(b2);
		if(bruker1 ==null) {
			lagBruker(b1, b1, "Peter", "test@outlook.com", "test"); 
		}
		if(bruker2 ==null) {
			lagBruker(b2, b2, "Peter", "test@outlook.com", "test"); 
		}
	}
	
	public void lagTestSpillDeltakelser(String b1, String b2) {
		
		Bruker bruker1 = hentBruker(b1);
		Bruker bruker2 = hentBruker(b2);
		Spilldeltakelse spilldeltakelse1 = hentSpillDeltakelse(1, bruker1.getBrukerid());
		Spilldeltakelse spilldeltakelse2 = hentSpillDeltakelse(1, bruker2.getBrukerid());
		//slettSpillDeltakelse(spilldeltakelse1);
		//slettSpillDeltakelse(spilldeltakelse2);
		if(spilldeltakelse1==null) {
		lagSpillDeltakelse(b1, 1);
		}
		if(spilldeltakelse2==null) {
		lagSpillDeltakelse(b2, 1);
		}
	
	}
	public void lagTestSpill() {
		
		lagTestBrukere("Ola", "Ida");
		
		Spill spill = hentSpill(1);
		if(spill==null) {
			lagSpill("A");
		}
	
		lagTestSpillDeltakelser("Ola", "Ida");	
	
	}
		
	public List<Spilldeltakelse> hentSpillDeltakelserForSpill(Spill spill){
		
		List<Spilldeltakelse> sd = new ArrayList<Spilldeltakelse>();
		Integer id = spill.getSpillid();
		
		for(Spilldeltakelse s: sprepo.findAll()) {
			if(s.getId().getSpillid() == id) {
				sd.add(s);
			}
		}
		return sd;
	}
	
	public Integer okNyrunde(Spill spill) {
		
		spill.setRunde(spill.getRunde()+1);
		spillrepo.save(spill);
		return spill.getRunde();
	}

/*	
	public void TestSpill(List<Spilldeltakelse> spillDeltakelser, Spill spill) {		
	       for(int i=0; i<15; i++){
	            Integer rundeNr = okNyrunde(spill);
	            spillRunde(rundeNr, spillDeltakelser);
	            
	            if(rundeNr ==15){
	                for(Spilldeltakelse spillDeltakelse1: spillDeltakelser){
//	                    printer spillDeltakselse når spillet er ferdig
	                    System.out.println(spillDeltakelse1.toString());
	                }
	            }
	        }
	}
	*/
	
    public void spillRunde(int runde, List<Spilldeltakelse> spillDeltakelser){
//      hver spiller i spiller-listen tar én tur
      for(Spilldeltakelse spillDeltakelse : spillDeltakelser){
//          en tur blir opprettet for gjeldende bruker
          Tur tur = new Tur();
//          spilleren tar sin tur på gjeldende runde
          taTur(tur, runde, spillDeltakelse);
      }
    } 
    
    public void leggTilResultat(int runde, int poeng, Spilldeltakelse spillDeltakelse){
        spillDeltakelse.getResultat()[runde-1] = poeng;
    	spillDeltakelse.setResultat(spillDeltakelse.getResultat());
    	sprepo.save(spillDeltakelse);
    }
	
    public void taTur(Tur tur, int runde, Spilldeltakelse spillDeltakelse){
//      de to første kastene kan man velge hva man skal beholde
      System.out.println("runde nr " + runde);
      for(int i=0; i<2; i++){
//          trill terninger
          tur.kast();
//          velg hva som skal beholdes
          tur.velg();
      }
//      det tredje kastet
      tur.kast();

//      registrere resultatet fra terningene etter siste kast
//      - runde som parameter for å se opp mot gjeldende regler
//      - spillDeltakelse for å kunne lagre resultatene
      registrer(tur, runde, spillDeltakelse);
  }
    
   public void registrer(Tur tur ,int runde, Spilldeltakelse spillDeltakelse){

	   leggTilResultat(runde, tur.turFerdig(tur.getTerninger(),runde), spillDeltakelse);
	   
        System.out.println(spillDeltakelse.toString());
    }

	public List<Bruker> findAll() {
		return brukerepo.findAll();
		
	}

	public List<Spilldeltakelse> findAllSpiller() {
		
		return sprepo.findAll();
	}
   public List<Spill> findAllSpill() {
		
		return spillrepo.findAll();
	}


    
}
