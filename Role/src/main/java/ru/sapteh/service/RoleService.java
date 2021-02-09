package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.Role;

import java.util.List;

public class RoleService implements Dao<Role, Integer> {
    private final SessionFactory factory;

    public RoleService(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public Role read(Integer id) {
        try(Session session = factory.openSession()){
            Role role = session.get(Role.class, id);
            return role;
        }
    }

    @Override
    public List<Role> readByAll() {
        try(Session session = factory.openSession()){
            Query<Role> result = session.createQuery("FROM Role");
            return result.list();
        }
    }

    @Override
    public void create(Role role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Role role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Role role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(role);
            session.getTransaction().commit();
        }
    }
}

