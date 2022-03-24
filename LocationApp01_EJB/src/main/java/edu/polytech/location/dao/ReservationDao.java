package edu.polytech.location.dao;

import edu.polytech.location.model.ReservationBean;

import java.util.List;

/**
 * The Interface ReservationDao.
 * Used to manage the reservation table in the database.
 */
public interface ReservationDao {

    /**
     * Add a reservation to the database.
     * @param bean the reservation bean to add to the database.
     */
    void createReservation(ReservationBean bean);

    /**
     * Gets all the reservations.
     * @return the list of all the reservations in the database.
     */
    List<ReservationBean> getReservations();

    /**
     * Gets the reservation with the given id.
     * @param id the id of the reservation to get.
     * @return the reservation with the given id.
     */
    ReservationBean getReservation(Integer id);

}
