package no.hvl.dat109.model.idclass;

import java.io.Serializable;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;



@Embeddable
public class SpillDeltakelseId implements Serializable{
	
	@Column(name="spillid")
	Integer spillid;
	
	@Column(name="brukerid")
	Integer brukerid;

	public SpillDeltakelseId(Integer spillid, Integer brukerid) {
		super();
		this.spillid = spillid;
		this.brukerid = brukerid;
	}
	public SpillDeltakelseId() {
		
	}

	public Integer getSpillid() {
		return spillid;
	}

	public void setSpillid(Integer spillid) {
		this.spillid = spillid;
	}

	public Integer getSpilerid() {
		return brukerid;
	}

	public void setSpilerid(Integer brukerid) {
		this.brukerid = brukerid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brukerid, spillid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpillDeltakelseId other = (SpillDeltakelseId) obj;
		return Objects.equals(brukerid, other.brukerid) && Objects.equals(spillid, other.spillid);
	}
	
}
