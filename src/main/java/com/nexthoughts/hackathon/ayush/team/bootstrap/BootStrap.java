package com.nexthoughts.hackathon.ayush.team.bootstrap;


import com.nexthoughts.hackathon.ayush.team.command.UserCommand;
import com.nexthoughts.hackathon.ayush.team.domains.Role;
import com.nexthoughts.hackathon.ayush.team.domains.User;
import com.nexthoughts.hackathon.ayush.team.services.RoleService;
import com.nexthoughts.hackathon.ayush.team.services.UserService;
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

        if (userService.list().isEmpty()) {
            createAdminUser();
            createUser();
        }

    }

    public void createAdminUser() {
        UserCommand adminUserCommand = new UserCommand();
        adminUserCommand.setEmail("nakul+101@nexthoughts.com");
        adminUserCommand.setUsername("nakul@admin");
        adminUserCommand.setPassword("nakul@admin");
        User savedAdmin = userService.read(userService.create(adminUserCommand));
        String admin = "ROLE_ADMIN";
        Role roleAdmin = roleService.read(roleService.create(admin, savedAdmin));
        System.out.println("Admin created with ROLE_ADMIN and username - " + savedAdmin.getUsername() + "  and password -  " + savedAdmin.getPassword());
    }


    public void createUser() {
        UserCommand userCommand = new UserCommand();
        userCommand.setEmail("nakul+121@nexthoughts.com");
        userCommand.setUsername("nakul@user");
        userCommand.setPassword("nakul@user");
        User savedUser = userService.read(userService.create(userCommand));
        String user = "ROLE_USER";
        Role roleUser = roleService.read(roleService.create(user, savedUser));
        System.out.println("User created with ROLE_USER and username - " + savedUser.getUsername() + "  and password -  " + savedUser.getPassword());

    }
}
