package edu.polytech.location.dao;

import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public interface ReservationDao {

    public void createReservation(ReservationBean bean);
    public List<ReservationBean> getReservations();
    public ReservationBean getReservation(Integer id);

}
