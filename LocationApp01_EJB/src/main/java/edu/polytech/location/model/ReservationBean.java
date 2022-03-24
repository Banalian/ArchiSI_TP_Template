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

    private int idUser;

    private int dureeEnJours;

    private double prixMenage;
    private double prixAssurance;
    private double reducSejourLong;
    private double reducSejourLointain;
    private double reducSup500;
    private double reducFidelite;
    private double prixLocation;
    private double prixTot;

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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getReducFidelite() {
        return reducFidelite;
    }

    public void setReducFidelite(double reducFidelite) {
        this.reducFidelite = reducFidelite;
    }

    public LocationBean getAppart() {
        return appart;
    }

    public void setAppart(LocationBean appart) {
        this.appart = appart;
    }

    public double getPrixMenage() {
        return prixMenage;
    }

    public void setPrixMenage(double prixMenage) {
        this.prixMenage = prixMenage;
    }

    public double getPrixAssurance() {
        return prixAssurance;
    }

    public void setPrixAssurance(double prixAssurance) {
        this.prixAssurance = prixAssurance;
    }

    public double getReducSejourLong() {
        return reducSejourLong;
    }

    public void setReducSejourLong(double reducSejourLong) {
        this.reducSejourLong = reducSejourLong;
    }

    public double getReducSejourLointain() {
        return reducSejourLointain;
    }

    public void setReducSejourLointain(double reducSejoutLointain) {
        this.reducSejourLointain = reducSejoutLointain;
    }

    public double getReducSup500() {
        return reducSup500;
    }

    public void setReducSup500(double reducSup500) {
        this.reducSup500 = reducSup500;
    }

    public ReservationBean() {}

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

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prix) {
        this.prixLocation = prix;
    }

    public double getPrixTot() {
        return prixTot;
    }

    public void setPrixTot(double newPrixTot) {
        prixTot = newPrixTot;
    }

}
