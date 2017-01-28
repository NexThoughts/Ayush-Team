package com.nexthoughts.hackathon.ayush.team.services;


import com.nexthoughts.hackathon.ayush.team.command.UserCommand;
import com.nexthoughts.hackathon.ayush.team.domains.Role;
import com.nexthoughts.hackathon.ayush.team.domains.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class BootStrap implements InitializingBean {


    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    private final Logger log = org.slf4j.LoggerFactory.getLogger(BootStrap.class);

    @Override
    @Transactional
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init Bootstrap");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("=============================================================");

        if (userService.list().isEmpty()) {
            createAdmin();
            createUser();
            createUserAndAdmin();
        }

    }

    public void createAdmin() {
        UserCommand adminUserCommand = new UserCommand();
        adminUserCommand.setEmail("nakul+101@nexthoughts.com");
        adminUserCommand.setUsername("nakul@admin");
        adminUserCommand.setPassword("nakul@admin");
        adminUserCommand.setFirstName("Nakul");
        adminUserCommand.setLastName("Pant");
        User savedAdmin = userService.read(userService.create(adminUserCommand));
        Role roleAdmin = roleService.read(roleService.create("ROLE_ADMIN", savedAdmin));
        System.out.println("Admin created with ROLE_ADMIN and username - " + savedAdmin.getUsername() + "  and password -  " + savedAdmin.getPassword());
    }


    public void createUser() {
        UserCommand userCommand = new UserCommand();
        userCommand.setEmail("nakul+121@nexthoughts.com");
        userCommand.setUsername("nakul@user");
        userCommand.setPassword("nakul@user");
        userCommand.setFirstName("Nakul");
        userCommand.setLastName("Pant");
        User savedUser = userService.read(userService.create(userCommand));
        Role roleUser = roleService.read(roleService.create("ROLE_USER", savedUser));
        System.out.println("User created with ROLE_USER and username - " + savedUser.getUsername() + "  and password -  " + savedUser.getPassword());

    }

    public void createUserAndAdmin() {
        UserCommand userCommand = new UserCommand();
        userCommand.setEmail("nakul+1@nexthoughts.com");
        userCommand.setUsername("nakul");
        userCommand.setPassword("nakul");
        userCommand.setFirstName("Nakul");
        userCommand.setLastName("Pant");
        User savedUser = userService.read(userService.create(userCommand));
        Role roleUser = roleService.read(roleService.create("ROLE_USER", savedUser));
        Role roleAdmin = roleService.read(roleService.create("ROLE_ADMIN", savedUser));
        System.out.println("User created with ROLE_USER and username - " + savedUser.getUsername() + "  and password -  " + savedUser.getPassword());
    }
}
