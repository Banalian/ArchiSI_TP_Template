package edu.polytech.location.business;

import java.util.List;

import javax.ejb.Remote;

import edu.polytech.location.model.LocationBean;

@Remote
public interface BusinessRemote {

    public void addLocation(LocationBean bean);

    public List<LocationBean> getLocations();

    public LocationBean getLocation(Integer id);
}
