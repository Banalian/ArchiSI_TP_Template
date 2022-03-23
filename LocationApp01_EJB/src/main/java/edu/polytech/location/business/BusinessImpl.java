package edu.polytech.location.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.polytech.location.dao.LocationDao;
import edu.polytech.location.model.LocationBean;

@Stateless
public class BusinessImpl implements BusinessLocal, BusinessRemote {

    @Inject
    private LocationDao locationDao;

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

}
