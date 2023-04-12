package no.hvl.dat109.yatzy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
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

	@InjectMocks
	TestSpillService bs;
	
	@Mock
	SpillRepo spillrepo;
	
	
	
    /**
    * Tester SpillRepo.
    */
    @DisplayName("SpillRepoTest")
	@Test
	public void SpillTest()
	{
		List<Spill> list = new ArrayList<Spill>();
		
		Spill første = new Spill("A");
		Spill andre= new Spill("F");
		Spill tredje= new Spill("N");
		Spill fjerde= new Spill("A");
		Spill femte= new Spill("F");
		list.add(første);
		list.add(andre);
		list.add(tredje);
		list.add(fjerde);
		
		

		when(spillrepo.findAll()).thenReturn(list);
		List<Spill> spillist = bs.findAllSpill();
		
		assertEquals(4, spillist.size());
		Spill hentetSpill=bs.hentSpill(1);
		assertEquals(første, hentetSpill);
		assertTrue(spillist.contains(første));
		assertFalse(spillist.contains(femte));
	
		//when(spillrepo.getById(1)).thenReturn(første);
		//assertEquals(første,spillrepo.getById(1));
	}

	

}
