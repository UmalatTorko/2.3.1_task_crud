package ru.gordanov.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gordanov.dao.UserDao;
import ru.gordanov.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
