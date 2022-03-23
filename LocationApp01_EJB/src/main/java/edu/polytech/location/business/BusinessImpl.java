package edu.polytech.location.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.polytech.location.dao.LocationDao;
import edu.polytech.location.dao.ReservationDao;
import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

@Stateless
public class BusinessImpl implements BusinessLocal, BusinessRemote {

    @Inject
    private LocationDao locationDao;

    @Inject
    private ReservationDao reservationDao;


    @Override
    public void addLocation(LocationBean bean) {
        locationDao.createLocation(bean);
    }

    @Override
    public List<LocationBean> getLocations() {
        return locationDao.getLocations();
    }

    @Override
    public LocationBean getLocation(Integer id) {
        return locationDao.getLocation(id);
    }

    @Override
    public void computePrice(ReservationBean reservation){
        //TODO actually compute prices
    }

    @Override
    public void insertReservation(ReservationBean reservation){
        reservationDao.createReservation(reservation);
    }

}
