package ru.gordanov.dao;

import org.springframework.stereotype.Repository;
import ru.gordanov.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        List<Role> list = entityManager
                .createQuery("from Role", Role.class)
                .getResultList();
        return list;
    }
}
