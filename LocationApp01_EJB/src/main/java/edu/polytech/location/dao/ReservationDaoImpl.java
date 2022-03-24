package edu.polytech.location.dao;

import edu.polytech.location.model.ReservationBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Implementation of the ReservationDao interface.
 * Used to manage the reservation table in the database using JPA.
 */
@Stateless
public class ReservationDaoImpl implements ReservationDao {

    /**
     * The entity manager used to access the database and to persist the data.
     */
    @PersistenceContext(unitName = "LocationEJB")
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public void createReservation(ReservationBean bean) {
        em.persist(bean);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ReservationBean> getReservations() {
        Query request = em.createQuery("select r from ReservationBean r");
        return  request.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservationBean getReservation(Integer id) {
        return em.find(ReservationBean.class, id);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<ReservationBean> getReservationsOfUser(int id){

        Query request = em.createQuery("select r from ReservationBean as r where r.idUser = 42 order by idReservation");
        return  request.getResultList();

    }
}
