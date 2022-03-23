package edu.polytech.location.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class ReservationBean implements Serializable{

    private LocationBean appart;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    private float prixMenage;
    private float prixAssurance;
    private float reducSejourLong;
    private float reducSejoutLointain;
    private float reducSup500;
    private float prixLocation;
    private float PrixTot;

    public LocationBean getAppart() {
        return appart;
    }

    public void setAppart(LocationBean appart) {
        this.appart = appart;
    }

    public float getPrixMenage() {
        return prixMenage;
    }

    public void setPrixMenage(float prixMenage) {
        this.prixMenage = prixMenage;
    }

    public float getPrixAssurance() {
        return prixAssurance;
    }

    public void setPrixAssurance(float prixAssurance) {
        this.prixAssurance = prixAssurance;
    }

    public float getReducSejourLong() {
        return reducSejourLong;
    }

    public void setReducSejourLong(float reducSejourLong) {
        this.reducSejourLong = reducSejourLong;
    }

    public float getReducSejoutLointain() {
        return reducSejoutLointain;
    }

    public void setReducSejoutLointain(float reducSejoutLointain) {
        this.reducSejoutLointain = reducSejoutLointain;
    }

    public float getReducSup500() {
        return reducSup500;
    }

    public void setReducSup500(float reducSup500) {
        this.reducSup500 = reducSup500;
    }

    public ReservationBean() {

    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public float getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(float prix) {
        this.prixLocation = prix;
    }

    public float getPrixTot() {
        return PrixTot;
    }

    public void setPrixTot(float prixTot) {
        PrixTot = prixTot;
    }

}
