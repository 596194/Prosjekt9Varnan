package no.hvl.dat109.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.hvl.dat109.model.Bruker;

@Repository
public interface BrukerRepo extends JpaRepository<Bruker, Integer> {

	List<Bruker> findAll();
	
}
