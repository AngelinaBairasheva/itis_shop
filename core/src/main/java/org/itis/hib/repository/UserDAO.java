package org.itis.hib.repository;

import org.itis.hib.domain.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(User user);
    void addUser(User user);
    User getUserById(Integer id);
}
