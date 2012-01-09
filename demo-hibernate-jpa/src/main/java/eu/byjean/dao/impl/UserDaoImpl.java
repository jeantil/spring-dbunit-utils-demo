package eu.byjean.dao.impl;

import eu.byjean.dao.UserDao;
import eu.byjean.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

    public User findByUsername(String username) {
        Query query = getSession().createQuery("from User where username =:username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }
}
