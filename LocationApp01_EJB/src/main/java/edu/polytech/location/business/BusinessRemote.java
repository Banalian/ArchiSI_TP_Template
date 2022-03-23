package edu.polytech.location.business;

import java.util.List;

import javax.ejb.Remote;

import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

@Remote
public interface BusinessRemote {

    public void addLocation(LocationBean bean);

    public List<LocationBean> getLocations();

    public LocationBean getLocation(Integer id);

    public void computePrice(ReservationBean reservation);
    public void insertReservation(ReservationBean reservation);
}
