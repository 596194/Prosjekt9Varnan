package no.hvl.dat109.yatzy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.dat109.model.Bruker;
import no.hvl.dat109.model.Spill;
import no.hvl.dat109.model.Spilldeltakelse;
import no.hvl.dat109.model.idclass.SpillDeltakelseId;
import no.hvl.dat109.repo.BrukerRepo;
import no.hvl.dat109.repo.SpillDeltakelseRepo;
import no.hvl.dat109.service.TestSpillService;


/**
 * SpillerRepo testklassen.
 */
@ExtendWith(MockitoExtension.class) 
public class TestSpilldeltakelseRepo {

	@Mock
	TestSpillService mock;
	
	@Mock
	 SpillDeltakelseRepo dp;
	
	@BeforeEach
	public void setUp() {
		
		//mock = mock(TestSpillService.class);
		
		MockitoAnnotations.openMocks(this);

	}
	
	

/**
 * Tester SpillerRepo.
 */
    @DisplayName("SpilldeltakelseRepoTest")
	@Test
	public void SpilldeltakerTest()
	{
		List<Spilldeltakelse> list = new ArrayList<Spilldeltakelse>();
		Spilldeltakelse en = new Spilldeltakelse();
		Spilldeltakelse to=new Spilldeltakelse();
		Spilldeltakelse tre=new Spilldeltakelse();
		list.add(en);
		list.add(to);
		list.add(tre);

		when(mock.findAllSpiller()).thenReturn(list);
		List<Spilldeltakelse> spilerlist = mock.findAllSpiller();
		
		assertEquals(3, spilerlist.size());
	
	
		
	}
    /**
	 *tester metoden hentSpillDeltakelse
	 */
	@Test
	public void hentSpillDeltakelseTest()
	
	{
		 List<Spilldeltakelse> spillDeltakelse= new ArrayList<Spilldeltakelse> ();
		 Integer[] resultat= {1,2,7,9,3,6,2,9,3,9,3,6,23,12,9};
		 Integer[] resultat2={1,2,7,9,3,6,2,9,3,9,3,6,13,13,6};
		 Integer[] resultat3={1,2,7,9,3,6,2,9,3,9,3,6,13,13,6};
		 
		 Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		 Bruker bruker1=new Bruker("Elias1","Elias","Yakup", "Elias@yahoo.com", "23dfdfdv");
	     Bruker bruker2= new Bruker("Liam23","Olav","Liam", "liam@yahoo.com", "sdfdf");
	   
		 
		 Spill spill= new Spill("F"); 
		 
		 
		 
		 Spilldeltakelse spiller = new Spilldeltakelse(new SpillDeltakelseId(spill.getSpillid(), bruker.getBrukerid()), spill, bruker, resultat);
		 Spilldeltakelse spiller2 = new Spilldeltakelse(new SpillDeltakelseId(spill.getSpillid(), bruker1.getBrukerid()), spill, bruker1, resultat2);
		 Spilldeltakelse spiller3 = new Spilldeltakelse(new SpillDeltakelseId(spill.getSpillid(), bruker2.getBrukerid()), spill, bruker2, resultat3);
		 spillDeltakelse.add(spiller);
		 spillDeltakelse.add(spiller2);
		 spillDeltakelse.add(spiller3);
		 
		
		
		 when(mock.hentSpillDeltakelse(1,1)).thenReturn(spiller);
		 
		 Spilldeltakelse actual=mock.hentSpillDeltakelse(1,1);
		assertEquals(spiller,actual);
		
	}
	
	/**
	 *tester metoden slettSpillDeltakelse
	 */
	@Test
	public void sletttSpillDeltakelseTest()
	
	{   
		Integer[] resultat= {1,2,7,9,3,6,2,9,3,9,3,6,23,12,9};
	     Spill spill= new Spill("F");
		Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		Spilldeltakelse spillerdeltaker = new Spilldeltakelse(new SpillDeltakelseId(spill.getSpillid(),
				bruker.getBrukerid()),spill, bruker, resultat);
		
		mock.slettSpillDeltakelse(spillerdeltaker);
		
		
		spillerdeltaker= mock.hentSpillDeltakelse(1, 1);
		
		
		assertEquals(null,spillerdeltaker);
		
	}
	
	/**
	 *tester metoden hentSpillDeltakelserForSpill
	 */
	@Test
	public void hentSpillDeltakelserForSpillTest()
	
	{
		 List<Spilldeltakelse> spillDeltakelse= new ArrayList<Spilldeltakelse> ();
		 Integer[] resultat= {1,2,7,9,3,6,2,9,3,9,3,6,23,12,9};
		 Integer[] resultat2={1,2,7,9,3,6,2,9,3,9,3,6,13,13,6};
		 Integer[] resultat3={1,2,7,9,3,6,2,9,3,9,3,6,13,13,6};
		 
		 Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		 Bruker bruker1=new Bruker("Elias1","Elias","Yakup", "Elias@yahoo.com", "23dfdfdv");
	     Bruker bruker2= new Bruker("Liam23","Olav","Liam", "liam@yahoo.com", "sdfdf");
	    
		 Spill spill= new Spill("F"); 
		 
		
		 
		 Spilldeltakelse spiller = new Spilldeltakelse(new SpillDeltakelseId(spill.getSpillid(), bruker.getBrukerid()), spill, bruker, resultat);
		 Spilldeltakelse spiller2 = new Spilldeltakelse(new SpillDeltakelseId(spill.getSpillid(), bruker1.getBrukerid()), spill, bruker1, resultat2);
		 Spilldeltakelse spiller3 = new Spilldeltakelse(new SpillDeltakelseId(spill.getSpillid(), bruker2.getBrukerid()), spill, bruker2, resultat3);
		 spillDeltakelse.add(spiller);
		 spillDeltakelse.add(spiller2);
		 spillDeltakelse.add(spiller3);
		 
		
		
		 when(mock.hentSpillDeltakelserForSpill(spill)).thenReturn(spillDeltakelse);
		 List<Spilldeltakelse> spillere=mock.hentSpillDeltakelserForSpill(spill);		 
		 
		
		 
		assertTrue(spillere.contains(spiller));
		assertEquals(3, spillere.size());
		assertTrue(spillere.contains(spiller2));
		assertTrue(spillere.contains(spiller3));
	}
	
}
