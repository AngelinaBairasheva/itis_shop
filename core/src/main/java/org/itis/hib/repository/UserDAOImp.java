package org.itis.hib.repository;

import org.hibernate.SessionFactory;
import org.itis.hib.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserById(Integer id) {
       return (User) sessionFactory.getCurrentSession().load(User.class, id);
    }
}
