package no.hvl.dat109.yatzy;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.dat109.model.Bruker;
import no.hvl.dat109.repo.BrukerRepo;
import no.hvl.dat109.service.TestSpillService;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.transform.Source;

@ExtendWith(MockitoExtension.class) 
class TestSpillServiceBruker {

	@InjectMocks
	TestSpillService bs;
	
	@Mock
	BrukerRepo pr;
	
	
	@Test
	void finnerAlleBrukker() {
		
		//Arrange
		when(pr.findAll()).thenReturn(List.of(
				new Bruker("Sara1","Sara","Petter", "sara@yahoo.com", "1234abds"),
				new Bruker("Elias1","Elias","Yakup", "Elias@yahoo.com", "23dfdfdv"),
				new Bruker("Liam23","Olav","Liam", "liam@yahoo.com", "sdfdf"),
				new Bruker("Jasmin23","Jasmin","Ali", "Jasmin@yahoo.com", "dfdsfdgfd"),
				new Bruker("Nora8","Nora","Oscar", "Nora@yahoo.com", "okh45asf")));
		
		//Act
		List<Bruker> allebrukkere = bs.findAll();
		
		
		//Assert
		assertEquals(5, allebrukkere.size());
		//assertTrue(allebrukkere.contains"Sara"));
		//assertFalse(allebrukkere.contains("Ahmad"));
		//assertTrue(allebrukkere.contains("Nora"));
	}
	@Test
	public void hentBrukerTest()
	{
		bs.hentBruker("Sara1");
}
	
	@Test
	public void slettBrukerTest()
	{
		Bruker bruker = new Bruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");

		bs.slettBruker(bruker);
}
	@Test
	public void lagBrukerTest()
	{
		bs.lagBruker("Sara1","Sara","Yakup","sdsd@ysdfsfs", "asdsds123");
}
}