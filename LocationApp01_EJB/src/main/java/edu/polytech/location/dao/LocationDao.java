package edu.polytech.location.dao;

import java.util.List;

import edu.polytech.location.model.LocationBean;

/**
 * The Interface LocationDao.
 * Used to manage the location table in the database.
 */
public interface LocationDao {

    /**
     * Adds the  to the database.
     * @param bean the location bean to add to the database
     */
    void createLocation(LocationBean bean);

    /**
     * Get all the locations in the database.
     * @return the list of all the locations in the database
     */
    List<LocationBean> getLocations();

    /**
     * Get the location with the given id.
     * @param id the id of the location to get
     * @return the location with the given id
     */
    LocationBean getLocation(Integer id);


    /**
     * Delete the location with the given id.
     * @param id the id of the location to delete
     *            if the id is null, nothing is deleted
     */
    void deleteLocation(Integer id);
}
