package edu.polytech.location.business;

import java.util.List;

import javax.ejb.Local;

import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

@Local
public interface BusinessLocal {

    public void addLocation(LocationBean bean);

    public List<LocationBean> getLocations();

    public LocationBean getLocation(Integer id);

    public void computePrice(ReservationBean reservation);

    public void insertReservation(ReservationBean reservation);
}
