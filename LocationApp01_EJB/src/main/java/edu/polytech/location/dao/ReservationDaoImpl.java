package edu.polytech.location.dao;

import edu.polytech.location.model.ReservationBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ReservationDaoImpl implements ReservationDao {

    @PersistenceContext(unitName = "LocationEJB")
    private EntityManager em;

    @Override
    public void createReservation(ReservationBean bean) {
        em.persist(bean);
    }

    @Override
    public List<ReservationBean> getReservations() {
        Query request = em.createQuery("select r from ReservationBean r");
        return  request.getResultList();
    }

    @Override
    public ReservationBean getReservation(Integer id) {
        return em.find(ReservationBean.class, id);
    }
}
