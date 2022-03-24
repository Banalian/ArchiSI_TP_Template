package edu.polytech.location.business;

import java.util.List;

import javax.ejb.Remote;

import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

@Remote
public interface BusinessRemote {

    void addLocation(LocationBean bean);

    List<LocationBean> getLocations();

    LocationBean getLocation(Integer id);

    void computePrice(ReservationBean reservation, boolean hasInsurance, boolean hasCleaning);

    void insertReservation(ReservationBean reservation);
}
