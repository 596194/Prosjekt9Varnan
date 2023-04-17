package no.hvl.dat109.yatzy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mock.Strictness;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import jakarta.inject.Inject;
import no.hvl.dat109.model.Bruker;
import no.hvl.dat109.model.Spilldeltakelse;
import no.hvl.dat109.repo.BrukerRepo;
import no.hvl.dat109.service.TestSpillService;




//@ExtendWith(MockitoExtension.class) 
class TestSpillServiceBruker {


	@Mock
	TestSpillService mock;
		
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);

	}
	
	/**
	 *tester metoden findAll().
	 */
	@Test
	void finnerAlleBrukker() {
		
		//Arrange
		when(mock.findAll()).thenReturn(List.of(
				new Bruker("Sara1","Sara","Petter", "sara@yahoo.com", "1234abds"),
				new Bruker("Elias1","Elias","Yakup", "Elias@yahoo.com", "23dfdfdv"),
				new Bruker("Liam23","Olav","Liam", "liam@yahoo.com", "sdfdf"),
				new Bruker("Jasmin23","Jasmin","Ali", "Jasmin@yahoo.com", "dfdsfdgfd"),
				new Bruker("Nora8","Nora","Oscar", "Nora@yahoo.com", "okh45asf")));
		
		//Act
		List<Bruker> allebrukkere = mock.findAll();
		
		
		
		//Assert
		assertEquals(5, allebrukkere.size());
		assertTrue(allebrukkere.get(3).getBrukernavn().equals("Jasmin23"));
		assertTrue(allebrukkere.get(4).getBrukernavn().equals("Nora8"));
		
			
	}
	
	/**
	 *tester metoden hentBruker
	 */
	@Test
	public void hentBrukerTest()
	
	{
		Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		
		 when(mock.hentBruker("Sara1")).thenReturn(bruker);
		 
		Bruker actual=mock.hentBruker("Sara1");
		assertEquals(bruker,actual);
				
}
	
	/**
	 *tester metoden slettBruker
	 */
	@Test
	public void slettBrukerTest()
	{
		Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		mock.lagBruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		assertEquals(bruker.getBrukernavn(),"Sara1");
		System.out.println(bruker.getBrukernavn());
		mock.slettBruker(bruker);
		
		bruker = mock.hentBruker("Sara1");
		
		assertEquals(null,bruker);
	    
	    
			
}
	/**
	 *tester metoden lagBruker
	 */
	@Test
	public void lagBrukerTest()
	
	{
		Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		mock.lagBruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		when(mock.hentBruker("Sara1")).thenReturn(bruker);
		System.out.println(bruker.getEtternavn());
		
		assertEquals(bruker.getBrukernavn(),"Sara1");
		assertEquals(bruker.getEtternavn(),"Yakup");
}

	@DisplayName("Tester at Brukeren blir opprettet,(Bruker klassen)")
	@Test
	void RegistreringOfBruker() {
		Bruker bruker1=new Bruker("Sara1","Sara","Petter", "sara@yahoo.com", "1234abds");
		Bruker bruker2=new Bruker("Elias1","Elias","Yakup", "Elias@yahoo.com", "23dfdfdv");

		 assertTrue(bruker1.getBrukernavn()=="Sara1");
		 assertTrue(bruker1.getFornavn()=="Sara");
		 assertTrue(bruker2.getBrukernavn()=="Elias1");
		 assertFalse(bruker2.getBrukernavn()=="Elias");

	}
	
}