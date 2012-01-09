package eu.byjean.dao;

import eu.byjean.model.User;

public interface UserDao {
    public User findByUsername(String username);
}
