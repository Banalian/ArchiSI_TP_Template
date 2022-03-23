package edu.polytech.dao;

import java.util.List;

public interface Dao {

    public void create(Object o);

    public void update(Object o);

    public void delete(Object o);

    public Object find(Object o);

    public List<Object> findAll();
}
