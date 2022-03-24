package edu.polytech.location.model;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Entity implementation class for Entity: LocationBean
 * A location is a place where a user can stay. Contains multiple explicit informations.
 * Also contains a picture.
 */
@Entity(name = "locationbean")
public class LocationBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocation;
    private Double nightPrice;
    private String address;
    private String city;
    private String zipCode;
    @Lob
    private byte[] picture;
    private static final long serialVersionUID = 1L;

    public LocationBean() {
        super();
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Double getNightPrice() {
        return this.nightPrice;
    }

    public void setNightPrice(Double nightPrice) {
        this.nightPrice = nightPrice;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    /**
     * Transforme le byte[] contenant les données de l'images en String.
     * 
     * @return La chaîne de caractère permettant l'affichage d'une image depuis une
     *         JSP.
     */
    public String getBase64Image() {
        return Base64.getEncoder().encodeToString(this.picture);
    }
}
