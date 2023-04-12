package no.hvl.dat109.model;


import java.util.Arrays;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import no.hvl.dat109.util.PassordUtil;



@Entity
@Table(schema = "Prosjekt9")
public class Bruker {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer brukerid;
	
	private String brukernavn;
	
	private String fornavn;
	
	private String etternavn;

	private String epost;
	
	private  String salt;
	
	private String passordhash;
	
	 @OneToMany(mappedBy = "brukerid")
	  List<Spilldeltakelse> spillDeltakelse;

	public Bruker() {
		
	}
	
	public Bruker(String brukernavn, String fornavn, String etternavn, String epost, String passord) {
		super();
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.epost = epost;
		this.salt = PassordUtil.genererTilfeldigSalt();
		this.passordhash = PassordUtil.hashMedSalt(passord, salt);
	}

	public Integer getBrukerid() {
		return brukerid;
	}

	public void setBrukerid(Integer brukerid) {
		this.brukerid = brukerid;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassordhash() {
		return passordhash;
	}

	public void setPassordhash(String passordhash) {
		this.passordhash = passordhash;
	}

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(brukernavn, epost, etternavn, fornavn, passordhash, salt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bruker other = (Bruker) obj;
		return Objects.equals(brukernavn, other.brukernavn) && Objects.equals(epost, other.epost)
				&& Objects.equals(etternavn, other.etternavn) && Objects.equals(fornavn, other.fornavn)
				&& Objects.equals(passordhash, other.passordhash) && Objects.equals(salt, other.salt);
	}
	


	
}