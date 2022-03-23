package edu.polytech.dao;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class DaoImpl implements Dao{

    @PersistenceContext(unitName = "GestionEJB")
    private javax.persistence.EntityManager em;

}
