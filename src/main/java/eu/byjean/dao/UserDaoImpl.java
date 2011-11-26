package eu.byjean.dao;

import eu.byjean.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    protected final Session getSession() {
        return (Session) entityManager.getDelegate();
    }

    protected final Criteria getCriteria() {
        return getSession().createCriteria(User.class);
    }

    @Override
    public User findByUsername(String username) {
        Query query = getSession().createQuery("from User where username=:username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
