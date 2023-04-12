package no.hvl.dat109.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.hvl.dat109.model.Spilldeltakelse;
import no.hvl.dat109.model.idclass.SpillDeltakelseId;


@Repository
public interface SpillDeltakelseRepo extends JpaRepository<Spilldeltakelse, SpillDeltakelseId> {
 
	List<Spilldeltakelse> findAll();

}
