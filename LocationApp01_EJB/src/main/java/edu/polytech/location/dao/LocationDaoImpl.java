package edu.polytech.location.dao;

import edu.polytech.location.model.LocationBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LocationDaoImpl implements LocationDao{

    @PersistenceContext(unitName = "LocationEJB")
    private EntityManager em;

    @Override
    public void createLocation(LocationBean bean) {
        em.persist(bean);
    }

    @Override
    public List<LocationBean> getLocations() {
        Query request = em.createQuery("select l from locationbean l");
        return  request.getResultList();
    }

    @Override
    public LocationBean getLocation(Integer id) {
        return em.find(LocationBean.class,id);
    }

}
