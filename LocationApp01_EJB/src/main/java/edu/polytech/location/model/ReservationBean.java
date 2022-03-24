package edu.polytech.location.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity implementation class for Entity: ReservationBean
 * A Reservation is a reservation of a place, with multiple informations like prices and dates.
 */
@Entity
public class ReservationBean implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @ManyToOne
    @JoinColumn(name = "idLocation")
    private LocationBean appart;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    private int dureeEnJours;

    private float prixMenage;
    private float prixAssurance;
    private float reducSejourLong;
    private float reducSejourLointain;
    private float reducSup500;
    private float reducFidelite;
    private float prixLocation;
    private float prixTot;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public int getDureeEnJours() {
        return dureeEnJours;
    }

    public void setDureeEnJours(int dureeEnJours) {
        this.dureeEnJours = dureeEnJours;
    }

    public float getReducFidelite() {
        return reducFidelite;
    }

    public void setReducFidelite(float reducFidelite) {
        this.reducFidelite = reducFidelite;
    }

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

    public float getReducSejourLointain() {
        return reducSejourLointain;
    }

    public void setReducSejourLointain(float reducSejoutLointain) {
        this.reducSejourLointain = reducSejoutLointain;
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
        return prixTot;
    }

    public void setPrixTot(float newPrixTot) {
        prixTot = newPrixTot;
    }

}
