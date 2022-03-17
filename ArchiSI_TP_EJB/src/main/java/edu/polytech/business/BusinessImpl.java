package edu.polytech.business;

import edu.polytech.dao.Dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BusinessImpl implements BusinessRemote, BusinessLocal {

    @Inject
    private Dao dao;

    @Override
    public void add(Object o) {
        dao.create(o);
    }

    @Override
    public void remove(Object o) {
        dao.delete(o);
    }

    @Override
    public void update(Object o) {
        dao.update(o);
    }

    @Override
    public Object find(Object id) {
        return dao.find(id);
    }

    @Override
    public List<Object> findAll() {
        return dao.findAll();
    }
}
