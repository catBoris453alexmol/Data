package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.Role;
import ru.sapteh.model.User;
import ru.sapteh.model.UserRoles;
import ru.sapteh.service.RoleService;
import ru.sapteh.service.UserRoleService;
import ru.sapteh.service.UserService;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Role, Integer> roleService = new RoleService(factory);
        Dao<User, Integer> userService = new UserService(factory);
        Dao<UserRoles, Integer> userRolesIntegerDao = new UserRoleService(factory);


        User ivan = userService.read(1);
        Role t = roleService.read(1);
        UserRoles date = userRolesIntegerDao.read(1);


        System.out.println(t);
     System.out.println(ivan);
     System.out.println(date);

//        ivan.getUserRoles().forEach(System.out::println);




        factory.close();

    }
}
