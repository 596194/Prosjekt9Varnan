package no.hvl.dat109.yatzy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import no.hvl.dat109.model.Spilltest;
import no.hvl.dat109.services.SpilltestService;
@ExtendWith(MockitoExtension.class) 
class SpillTestServiceTest {

	@Mock
	SpilltestService mock;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);

	}
	
	

    /**
    * Tester SpillRepo.
    */
    @DisplayName("SpillTestservice finnAlle metoden test.")
	@Test
	public void TesteSpillTestService()
	{
		List<Spilltest> list = new ArrayList<Spilltest>();
		
		Spilltest første = new Spilltest();
		Spilltest andre= new Spilltest();
		Spilltest tredje= new Spilltest();
		list.add(første);
		list.add(andre);
		list.add(tredje);
		
		
		

		when(mock.finnAlle()).thenReturn(list);
		List<Spilltest> spillist = mock.finnAlle();
		
		assertEquals(3, spillist.size());
		
	
		
	}
    @DisplayName("SpillTestservice finnSpillTest metoden.")
    @Test
	public void finnSpillTest()
	
	{
    	List<Spilltest> list = new ArrayList<Spilltest>();
    	Spilltest spill = new Spilltest();
    	list.add(spill);
		
		 when(mock.finnSpillTest(1)).thenReturn((List<Spilltest>) list);
		 
		 List<Spilltest> actual=mock.finnSpillTest(1);
		//assertEquals(actual,spill);
		assertTrue(actual.contains(spill));
		assertTrue(list.contains(spill));
			
}
}


