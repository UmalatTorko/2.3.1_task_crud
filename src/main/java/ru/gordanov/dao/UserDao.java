package ru.gordanov.dao;

import ru.gordanov.model.Role;
import ru.gordanov.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    User getUserById(long id);

    void update(User user);

    void delete(long id);

    User getUserByUsername(String username);
}
