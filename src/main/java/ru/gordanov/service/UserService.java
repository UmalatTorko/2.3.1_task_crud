package ru.gordanov.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.gordanov.model.Role;
import ru.gordanov.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    List<Role> getAllRoles();

    void save(User user);

    User getUserById(long id);

    void update(User user);

    void delete(long id);

    User getUserByUsername(String username);
}
