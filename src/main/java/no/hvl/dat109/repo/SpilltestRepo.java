package no.hvl.dat109.repo;

import no.hvl.dat109.model.Spill;
import no.hvl.dat109.model.Spilltest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpilltestRepo extends JpaRepository <Spilltest, Integer> {

    List<Spilltest> findAllBySpillid(Integer spillid);
}
