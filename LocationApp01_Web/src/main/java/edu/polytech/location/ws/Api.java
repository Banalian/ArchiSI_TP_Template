package edu.polytech.location.ws;

import edu.polytech.location.business.BusinessLocal;
import edu.polytech.location.model.LocationBean;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "LocationWs")
public class Api {

    @EJB
    private BusinessLocal business;

    @WebMethod
    public List<LocationBean> getLocations() {
        return business.getLocations();
    }

    @WebMethod
    public LocationBean getLocation(@WebParam(name = "id") int id) {
        return business.getLocation(id);
    }

    @WebMethod
    public boolean createLocation(@WebParam(name = "location") LocationBean location) {
        try{
            business.addLocation(location);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @WebMethod
    public boolean deleteLocation(@WebParam(name = "id") int id) {
        try{
            business.deleteLocation(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
