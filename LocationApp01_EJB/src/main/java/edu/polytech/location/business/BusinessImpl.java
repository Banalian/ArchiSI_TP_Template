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
    public void computePrice(ReservationBean reservation, boolean hasInsurance, boolean hasCleaning){
        //TODO actually compute prices
        //doing math
        float totalPrice = 0;

        if (hasCleaning){
            reservation.setPrixMenage(20);
            totalPrice+=reservation.getPrixMenage();
        }
        if(hasInsurance){
            //TODO: compute insurance price

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
        if(true){
            //TODO faire la difference avec aujourd'hui
        }

        reservation.setPrixTot(totalPrice);

    }

    @Override
    public void insertReservation(ReservationBean reservation){
        reservationDao.createReservation(reservation);
    }

}
