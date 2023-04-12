package no.hvl.dat109.yatzy;

import static org.junit.jupiter.api.Assertions.*;
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

import no.hvl.dat109.service.TestSpillService;
import no.hvl.dat109.repo.SpillRepo;
import no.hvl.dat109.model.Spill;


/**
 * SpillRepo testklassen.
 */
@ExtendWith(MockitoExtension.class) 
class SpillRepoTest {

	//@InjectMocks
	//TestSpillService bs;
	
	//@Mock
	//SpillRepo spillrepo;
	@Mock
	TestSpillService mock;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);

	}
	
	

    /**
    * Tester SpillRepo.
    */
    @DisplayName("SpillRepoTest")
	@Test
	public void SpillTest()
	{
		List<Spill> list = new ArrayList<Spill>();
		
		Spill første = new Spill("F");
		Spill andre= new Spill("A");
		Spill tredje= new Spill("A");
		list.add(første);
		list.add(andre);
		list.add(tredje);
		
		
		

		when(mock.findAllSpill()).thenReturn(list);
		List<Spill> spillist = mock.findAllSpill();
		
		assertEquals(3, spillist.size());
		
	
		
	}
    @Test
	public void hentSpillTest()
	
	{
		Spill spill = new Spill("F");
		
		 when(mock.hentSpill(1)).thenReturn(spill);
		 
		Spill actual=mock.hentSpill(1);
		assertEquals(spill,actual);
			
}
}
