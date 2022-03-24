package edu.polytech.location.business;

import java.util.List;

import javax.ejb.Local;

import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

@Local
public interface BusinessLocal {

    void addLocation(LocationBean bean);

    List<LocationBean> getLocations();

    LocationBean getLocation(Integer id);

    void computePrice(ReservationBean reservation, boolean hasInsurance, boolean hasCleaning);

    void insertReservation(ReservationBean reservation);
}
