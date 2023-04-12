package no.hvl.dat109.model;


import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema="Prosjekt9")
public class Spill {
	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer spillid;
	//@Column(name ="status")
	private String status;
	//@Column(name="runde")
	private Integer runde;

	 @OneToMany(mappedBy = "spillid")
	  List<Spilldeltakelse> spillDeltakelse;
	
	
	public Spill(String status) {
		this.status = status;
		this.runde=0;
	}
	public Spill() {
		
	}
	
	public Integer getSpillid() {
		return spillid;
	}
	public void setSpillid(Integer spillid) {
		this.spillid = spillid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getRunde() {
		return runde;
	}
	public void setRunde(Integer runde) {
		this.runde = runde;
	}	
}
