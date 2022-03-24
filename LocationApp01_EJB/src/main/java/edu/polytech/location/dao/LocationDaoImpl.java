package edu.polytech.location.dao;

import edu.polytech.location.model.LocationBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Implementation of the LocationDao interface.
 * Used to manage the location table in the database using JPA.
 */
@Stateless
public class LocationDaoImpl implements LocationDao{

    /**
     * The entity manager used to access the database and to persist the data.
     */
    @PersistenceContext(unitName = "LocationEJB")
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public void createLocation(LocationBean bean) {
        em.persist(bean);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LocationBean> getLocations() {
        Query request = em.createQuery("select l from locationbean l");
        return  request.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationBean getLocation(Integer id) {
        return em.find(LocationBean.class,id);
    }

}
