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
    public ReservationBean computeReservation(LocationBean location, Date dateDebut, Date dateFin, boolean hasInsurance, boolean hasCleaning){

        int dureeEnJour = 0;
        try {
            dureeEnJour = (int) TimeUnit.DAYS.convert(dateFin.getTime() - dateDebut.getTime(), TimeUnit.MILLISECONDS);
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }

        ReservationBean reservation = new ReservationBean();

        reservation.setAppart(location);
        reservation.setDateDebut(dateDebut);
        reservation.setDateFin(dateFin);
        reservation.setDureeEnJours(dureeEnJour);
        reservation.setPrixMenage(20);
        reservation.setPrixLocation((float) (dureeEnJour*reservation.getAppart().getNightPrice()));

        //RG1
        float totalPrice = reservation.getPrixLocation();
        //RG2
        if (hasCleaning){
            reservation.setPrixMenage(20);
            totalPrice+=reservation.getPrixMenage();
        }
        //RG3
        if(hasInsurance){
            reservation.setPrixAssurance(reservation.getPrixLocation()*(float)0.05);
            totalPrice+=reservation.getPrixAssurance();
        }
        //RG4
        if(reservation.getDureeEnJours()>=7){
            totalPrice-=reservation.getAppart().getNightPrice();
        }
        //RG5
        if(totalPrice>500){
            totalPrice*=0.9;
        }
        //RG6
        int dansCbDeJours;
        dansCbDeJours = (int) TimeUnit.DAYS.convert(reservation.getDateDebut().getTime() - Calendar.getInstance().getTime().getTime(), TimeUnit.MILLISECONDS);
        if(dansCbDeJours>30){
            totalPrice*=0.93;
        }
        //RG7

        //RG8
        reservation.setPrixTot(totalPrice);

        return reservation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertReservation(ReservationBean reservation){
        reservationDao.createReservation(reservation);
    }

}
