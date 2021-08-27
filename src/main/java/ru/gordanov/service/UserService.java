package ru.gordanov.service;

import ru.gordanov.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    User getUserById(long id);

    void update(User user);

    void delete(long id);
}
