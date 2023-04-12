package no.hvl.dat109.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.hvl.dat109.model.Spill;

@Repository
public interface SpillRepo extends JpaRepository<Spill, Integer> {

	List<Spill> findAll();
	
}
