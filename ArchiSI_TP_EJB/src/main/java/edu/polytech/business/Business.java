package edu.polytech.business;

import java.util.List;

public interface Business {

    public void add(Object o);

    public void remove(Object o);

    public void update(Object o);

    public Object find(Object id);

    public List<Object> findAll();


}
