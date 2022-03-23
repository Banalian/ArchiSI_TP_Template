package edu.polytech.location.dao;

import edu.polytech.location.model.ReservationBean;

import java.util.List;

public interface ReservationDao {

    void createReservation(ReservationBean bean);

    List<ReservationBean> getReservations();

    ReservationBean getReservation(Integer id);

}
