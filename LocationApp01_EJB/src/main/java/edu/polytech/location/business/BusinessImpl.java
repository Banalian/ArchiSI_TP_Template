package edu.polytech.location.business;

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

import static java.lang.Math.max;

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
    public void deleteLocation(Integer id){
        locationDao.deleteLocation(id);
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
        reservation.setPrixLocation((float) (dureeEnJour*reservation.getAppart().getNightPrice()));

        //RG1
        double totalPrice = reservation.getPrixLocation();
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
            reservation.setReducSejourLong(reservation.getAppart().getNightPrice());
            totalPrice-=reservation.getReducSejourLong();
        }
        //RG5
        if(totalPrice>500){
            reservation.setReducSup500(totalPrice*0.1);
            totalPrice*=0.9;
        }
        //RG6
        int dansCbDeJours;
        dansCbDeJours = (int) TimeUnit.DAYS.convert(reservation.getDateDebut().getTime() - Calendar.getInstance().getTime().getTime(), TimeUnit.MILLISECONDS);
        if(dansCbDeJours>30){
            reservation.setReducSejourLointain(totalPrice*0.07);
            totalPrice*=0.93;
        }
        //RG7
        //access DAO and count how many reservations there are with the user id
        List<ReservationBean> listRes = reservationDao.getReservationsOfUser(42);
        int count =listRes.size();

        //if we are on our 3rd reservation in a row
        if( (count+1)%3 == 0 && count != 0){
            //reduction is a percentage of the prices of these entries
            double reducFidelite = (listRes.get(listRes.size() - 1).getPrixTot() +
                                    listRes.get(listRes.size() - 2).getPrixTot()
                                    )*0.12;
            reservation.setReducFidelite(reducFidelite);
            totalPrice-=reducFidelite;
        }

        //RG8
        //avoiding negative total price, it makes no sense
        reservation.setPrixTot(max(totalPrice,0));

        //in our case, the only existing user is user 42, so we hard code it
        reservation.setIdUser(42);

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
