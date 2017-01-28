package com.nexthoughts.hackathon.ayush.team.controllers;

import com.nexthoughts.hackathon.ayush.team.command.UserCommand;
import com.nexthoughts.hackathon.ayush.team.domains.Role;
import com.nexthoughts.hackathon.ayush.team.domains.User;
import com.nexthoughts.hackathon.ayush.team.services.RoleService;
import com.nexthoughts.hackathon.ayush.team.services.UserService;
import com.nexthoughts.hackathon.ayush.team.services.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordValidator passwordValidator;

    public PasswordValidator getPasswordValidator() {
        return passwordValidator;
    }

    public void setPasswordValidator(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView showSignup() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/signup");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registerSignup(@Valid UserCommand userCommand, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("user/signup");
        } else {
            User savedUser = userService.read(userService.create(userCommand));
            Role roleUser = roleService.read(roleService.create("ROLE_USER", savedUser));
            modelAndView.addObject("success", "You have been registered successfully, please check your inbox to activate this account.");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
