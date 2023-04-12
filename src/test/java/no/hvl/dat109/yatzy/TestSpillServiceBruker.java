package no.hvl.dat109.yatzy;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mock.Strictness;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.inject.Inject;
import no.hvl.dat109.model.Bruker;
import no.hvl.dat109.repo.BrukerRepo;
import no.hvl.dat109.service.TestSpillService;




//@ExtendWith(MockitoExtension.class) 
class TestSpillServiceBruker {

   //@Mock
	//BrukerRepo br;
	
	//@InjectMocks
	@Mock
	TestSpillService mock;
		
	@BeforeEach
	public void setUp() {
		
		//mock = mock(TestSpillService.class);
		
		MockitoAnnotations.openMocks(this);

	}
	
	
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
		assertFalse(allebrukkere.contains("Ahmad"));
		assertTrue(allebrukkere.get(4).getBrukernavn().equals("Nora8"));
			
	}
	
	
	@Test
	public void hentBrukerTest()
	
	{
		Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		
		 when(mock.hentBruker("Sara1")).thenReturn(bruker);
		 
		Bruker actual=mock.hentBruker("Sara1");
		assertEquals(bruker,actual);
		
		
		
		
}
	
	
	@Test
	public void slettBrukerTest()
	{
		Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		
		assertEquals(bruker.getBrukernavn(),"Sara1");
		
		mock.slettBruker(bruker);
		
		when(mock.hentBruker("Sara1").getBrukernavn()).thenReturn(null);
		
		assertEquals(null,bruker);
}
	
	@Test
	public void lagBrukerTest()
	{
		
		//Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		
		Bruker bruker = mock.lagBrukereturn("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
		
		assertEquals(bruker.getBrukernavn(), "Sara1");
		
	
}
	
}