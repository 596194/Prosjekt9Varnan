package no.hvl.dat109.model;

import java.io.Serializable;
import java.util.Arrays;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import no.hvl.dat109.model.idclass.SpillDeltakelseId;

//@TypeDefs({@TypeDef(name = "integer-array",typeClass = CustomIntegerArrayType.class)})

@Entity
@Table(schema="Prosjekt9")
public class Spilldeltakelse {

	@EmbeddedId
	private SpillDeltakelseId Id;

	@ManyToOne
    @MapsId("spillid")
    @JoinColumn(name = "spillid")
	private Spill spillid;
	
	@ManyToOne
    @MapsId("brukerid")
    @JoinColumn(name = "brukerid")
	private Bruker brukerid;
	
	@Column(name="harspilt", nullable = false)
	private boolean harspilt;
	
	//@ElementCollection
	//@OrderColumn
	//@Type(type = "no.hvl.dat109.model.CustomIntegerArrayType")
	@Column(name="resultat", nullable = false, columnDefinition = "int[]")
	// @Convert(converter = CustomIntegerArrayType.class)
	private Integer[] resultat = new Integer[15];
	
	
	public Spilldeltakelse(SpillDeltakelseId id, Spill spillid, Bruker brukerid, Integer[] resultat) {
		super();
		Id = id;
		this.spillid = spillid;
		this.brukerid = brukerid;
		this.harspilt = false;
		this.resultat= resultat;
	}
	
	public Spilldeltakelse() {
		
	}

	public SpillDeltakelseId getId() {
		return Id;
	}

	public void setId(SpillDeltakelseId id) {
		Id = id;
	}

	public Spill getSpillid() {
		return spillid;
	}

	public void setSpillid(Spill spillid) {
		this.spillid = spillid;
	}

	public Bruker getBrukerid() {
		return brukerid;
	}

	public void setBrukerid(Bruker brukerid) {
		this.brukerid = brukerid;
	}

	public Integer[] getResultat() {
		return resultat;
	}

	public void setResultat(Integer[] resultat) {
		this.resultat = resultat;
	}
	
    public boolean getHarspilt() {
		return harspilt;
	}

	public void setHarspilt(boolean harspilt) {
		this.harspilt = harspilt;
	}

	public void leggTilResultat(int runde, int poeng){
        resultat[runde-1] = poeng;
    }
	
    public void taTur(Tur tur, int runde){
//      de to første kastene kan man velge hva man skal beholde
      System.out.println("runde nr " + runde);
      for(int i=0; i<2; i++){
//          trill terninger
          tur.kast();
//          velg hva som skal beholdes
          tur.velg();
      }
//      det tredje kastet
      tur.kast();

//      registrere resultatet fra terningene etter siste kast
//      - runde som parameter for å se opp mot gjeldende regler
//      - spillDeltakelse for å kunne lagre resultatene
      tur.registrer(runde, this);
  }

	@Override
	public String toString() {
		return "Spilldeltakelse [Id=" + Id + ", spillid=" + spillid + ", brukerid=" + brukerid + ", resultat="
				+ Arrays.toString(resultat) + "]";
	}
    
    
   
}
