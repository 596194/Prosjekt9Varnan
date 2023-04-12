package no.hvl.dat109.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "spilltest", schema = "prosjekt9")
public class Spilltest {

    private Integer spillid;
    @Id
    private Integer brukerid;
    private Integer enere;
    private Integer toere;
    private Integer treere;
    private Integer firere;
    private Integer femmere;
    private Integer seksere;
    private Integer etPar;
    private Integer toPar;
    private Integer treLike;
    private Integer fireLike;
    private Integer litenStraight;
    private Integer storStraight;
    private Integer hus;
    private Integer sjanse;
    private Integer yatzy;


    public Integer getSpillid() {
        return spillid;
    }

    public void setSpillid(Integer spillid) {
        this.spillid = spillid;
    }

    public Integer getBrukerid() {
        return brukerid;
    }

    public void setBrukerid(Integer brukerid) {
        this.brukerid = brukerid;
    }

    public Integer getEnere() {
        return enere;
    }

    public void setEnere(Integer enere) {
        this.enere = enere;
    }

    public Integer getToere() {
        return toere;
    }

    public void setToere(Integer toere) {
        this.toere = toere;
    }

    public Integer getTreere() {
        return treere;
    }

    public void setTreere(Integer treere) {
        this.treere = treere;
    }

    public Integer getFirere() {
        return firere;
    }

    public void setFirere(Integer firere) {
        this.firere = firere;
    }

    public Integer getFemmere() {
        return femmere;
    }

    public void setFemmere(Integer femmere) {
        this.femmere = femmere;
    }

    public Integer getSeksere() {
        return seksere;
    }

    public void setSeksere(Integer seksere) {
        this.seksere = seksere;
    }

    public Integer getEtPar() {
        return etPar;
    }

    public void setEtPar(Integer etPar) {
        this.etPar = etPar;
    }

    public Integer getToPar() {
        return toPar;
    }

    public void setToPar(Integer toPar) {
        this.toPar = toPar;
    }

    public Integer getTreLike() {
        return treLike;
    }

    public void setTreLike(Integer treLike) {
        this.treLike = treLike;
    }

    public Integer getFireLike() {
        return fireLike;
    }

    public void setFireLike(Integer fireLike) {
        this.fireLike = fireLike;
    }

    public Integer getLitenStraight() {
        return litenStraight;
    }

    public void setLitenStraight(Integer litenStraight) {
        this.litenStraight = litenStraight;
    }

    public Integer getStorStraight() {
        return storStraight;
    }

    public void setStorStraight(Integer storStraight) {
        this.storStraight = storStraight;
    }

    public Integer getHus() {
        return hus;
    }

    public void setHus(Integer hus) {
        this.hus = hus;
    }

    public Integer getSjanse() {
        return sjanse;
    }

    public void setSjanse(Integer sjanse) {
        this.sjanse = sjanse;
    }

    public Integer getYatzy() {
        return yatzy;
    }

    public void setYatzy(Integer yatzy) {
        this.yatzy = yatzy;
    }
}
