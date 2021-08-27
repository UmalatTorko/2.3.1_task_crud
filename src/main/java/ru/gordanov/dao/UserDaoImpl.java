package ru.gordanov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gordanov.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> list = entityManager
                .createQuery("from User", User.class)
                .getResultList();
        return list;
    }

    @Override
    public void save(User user) {
            entityManager.persist(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM User WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
