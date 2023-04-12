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
import no.hvl.dat109.model.Spiller;
import no.hvl.dat109.repo.BrukerRepo;
import no.hvl.dat109.repo.SpillerRepo;
import no.hvl.dat109.service.TestSpillService;

/**
 * SpillerRepo testklassen.
 */
@ExtendWith(MockitoExtension.class) 
public class TestSpillerRepo {

	@InjectMocks
	TestSpillService bs;
	
	@Mock
	SpillerRepo spillerrep;
	
	
/**
 * Tester SpillerRepo.
 */
    @DisplayName("SpillerRepoTest")
	@Test
	public void SpillerTest()
	{
		List<Spiller> list = new ArrayList<Spiller>();
		Spiller en = new Spiller((new Bruker("Sara1","Sara","Petter", "sara@yahoo.com", "1234abds")),1);
		Spiller to=new Spiller((new Bruker("Elias1","Elias","Yakup", "Elias@yahoo.com", "23dfdfdv")),2);
		Spiller tre=new Spiller((new Bruker("Liam23","Olav","Liam", "liam@yahoo.com", "sdfdf")),3);
		list.add(en);
		list.add(to);
		list.add(tre);

		when(spillerrep.findAll()).thenReturn(list);
		List<Spiller> spilerlist = bs.findAllSpiller();
		
		assertEquals(3, spilerlist.size());
		
		Spiller hentetSpiller=bs.hentSpiller("Sara");
		assertEquals(en, hentetSpiller);
	
		
	}

	
}
	
/*@SuppressWarnings("unlikely-arg-type")
@Test
void hentSpiller() {
	
	//Arrange
	when(spillerrep.findAll()).thenReturn(List.of(
			new Spiller((new Bruker("Sara1","Sara","Petter", "sara@yahoo.com", "1234abds")),1),
			new Spiller((new Bruker("Elias1","Elias","Yakup", "Elias@yahoo.com", "23dfdfdv")),2),
			new Spiller((new Bruker("Liam23","Olav","Liam", "liam@yahoo.com", "sdfdf")),3),
			new Spiller(new Bruker("Jasmin23","Jasmin","Ali", "Jasmin@yahoo.com", "dfdsfdgfd"),4)));
			
	
	//Act
	Spiller resultatt= bs.hentSpiller("Sara");
	
	Spiller resultatt2= bs.slettSpiller(resultatt);
	
	
	//Assert
	assertTrue(resultatt.getBrukernavn().equals("Sara1"));
	assertFalse(resultatt.getBrukernavn().equals("Liam23"));
	assertTrue(resultatt.getBrukernavn().getEtternavn().equals("Sara1"));
}
*/

/*
@Before(value = "")
public void init() {
	MockitoAnnotations.openMocks(this);
}
*/