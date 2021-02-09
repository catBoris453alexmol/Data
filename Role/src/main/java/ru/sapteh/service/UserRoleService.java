package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.Role;
import ru.sapteh.model.UserRoles;

import java.util.List;

public class UserRoleService implements Dao<UserRoles, Integer> {
    private final SessionFactory factory;

    public UserRoleService(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public UserRoles read(Integer id) {
        try(Session session = factory.openSession()){
            UserRoles role = session.get(UserRoles.class, id);
            return role;
        }
    }

    @Override
    public List<UserRoles> readByAll() {
        try(Session session = factory.openSession()){
            Query<UserRoles> result = session.createQuery("FROM UserRoles");
            return result.list();
        }
    }

    @Override
    public void create(UserRoles role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(UserRoles role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(UserRoles role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(role);
            session.getTransaction().commit();
        }
    }
}
