package edu.polytech.location.business;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

/**
 * The Interface BusinessLocal.
 * Used to define the business methods that would be used by local components.
 */
@Local
public interface BusinessLocal {

    /**
     * Save a location in the database.
     * @param bean the location to save
     */
    void addLocation(LocationBean bean);

    /**
     * Gets the list of all the locations.
     * @return the list of all the locations
     */
    List<LocationBean> getLocations();

    /**
     * Gets the location by id.
     * @param id the id of the location
     * @return the location
     */
    LocationBean getLocation(Integer id);

    /**
     * Delete a location from the database.
     * @param id the id of the location to delete
     */
    void deleteLocation(Integer id);

    /**
     * Compute the price of a reservation and fill all the fields of the bean.
     * @param location the location bean representing the reserved apartment
     * @param hasInsurance boolean to know if reservation includes cancel insurance
     * @param hasCleaning boolean to know if reservation includes the cleaning service
     * @return A reservationBean containing the inputted information and with the price reductions computed based on RG1 through 8
     */
    ReservationBean computeReservation(LocationBean location, Date dateDebut, Date dateFin, boolean hasInsurance, boolean hasCleaning);

    /**
     * Save a reservation in the database.
     * @param reservation the reservation to save
     */
    void insertReservation(ReservationBean reservation);

}
