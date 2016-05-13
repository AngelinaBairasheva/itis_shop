package org.itis.hib.service;

import org.itis.hib.domain.User;
import org.itis.hib.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
    @Transactional
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }
    @Transactional
    public User getUserById(Integer id) {
        return userDAO.getUserById(id);

    }
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

}
