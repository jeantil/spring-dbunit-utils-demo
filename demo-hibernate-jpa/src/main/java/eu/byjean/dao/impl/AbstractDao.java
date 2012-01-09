package eu.byjean.dao.impl;

import eu.byjean.dao.Dao;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<T, ID extends Serializable> implements Dao {

    private final Class<T> persistentClass;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        ParameterizedType genericType = (ParameterizedType) getClass().getGenericSuperclass();
        this.persistentClass = (Class<T>) genericType.getActualTypeArguments()[0];
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected final Session getSession() {
        return (Session) entityManager.getDelegate();
    }

    protected final Criteria getCriteria() {
        return getSession().createCriteria(persistentClass);
    }

    protected Class<T> getPersistentClass() {
        return persistentClass;
    }

}