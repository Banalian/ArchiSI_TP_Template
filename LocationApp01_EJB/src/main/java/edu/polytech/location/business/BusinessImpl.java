package edu.polytech.location.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.polytech.location.dao.LocationDao;
import edu.polytech.location.dao.ReservationDao;
import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

/**
 * Implementation of the business interface.
 * Uses javax to handle the model and DAO/database.
 */
@Stateless
public class BusinessImpl implements BusinessLocal, BusinessRemote {

    @Inject
    private LocationDao locationDao;

    @Inject
    private ReservationDao reservationDao;


    /**
     * {@inheritDoc}
     */
    @Override
    public void addLocation(LocationBean bean) {
        locationDao.createLocation(bean);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LocationBean> getLocations() {
        return locationDao.getLocations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationBean getLocation(Integer id) {
        return locationDao.getLocation(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void computePrice(ReservationBean reservation, boolean hasInsurance, boolean hasCleaning){

        float totalPrice = 0;

        if (hasCleaning){
            reservation.setPrixMenage(20);
            totalPrice+=reservation.getPrixMenage();
        }
        if(hasInsurance){
            totalPrice+=reservation.getPrixAssurance();
        }
        if(reservation.getDureeEnJours()>=7){
            totalPrice-=reservation.getAppart().getNightPrice();
        }
        if(totalPrice>500){
            totalPrice*=0.9;
        }
        int dansCbDeJours;
        dansCbDeJours = (int) TimeUnit.DAYS.convert(reservation.getDateDebut().getTime() - Calendar.getInstance().getTime().getTime(), TimeUnit.MILLISECONDS);
        if(dansCbDeJours>30){
            totalPrice*=0.93;
        }

        reservation.setPrixTot(totalPrice);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertReservation(ReservationBean reservation){
        reservationDao.createReservation(reservation);
    }

}
