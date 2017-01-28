package com.nexthoughts.hackathon.ayush.team.controllers;

import com.nexthoughts.hackathon.ayush.team.DTO.AppUtil;
import com.nexthoughts.hackathon.ayush.team.DTO.MailDTO;
import com.nexthoughts.hackathon.ayush.team.command.UserCommand;
import com.nexthoughts.hackathon.ayush.team.domains.Role;
import com.nexthoughts.hackathon.ayush.team.domains.User;
import com.nexthoughts.hackathon.ayush.team.services.EmailService;
import com.nexthoughts.hackathon.ayush.team.services.RoleService;
import com.nexthoughts.hackathon.ayush.team.services.UserService;
import com.nexthoughts.hackathon.ayush.team.services.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class UserController {

    @Value("${activation.url}")
    String activationUrl;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordValidator passwordValidator;

    @Autowired
    EmailService emailService;

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
            MailDTO mailDTO = new MailDTO();
            mailDTO.setTo(savedUser.getEmail());
            mailDTO.setFromEmailAddress("gaurav.gupta@nexthoughts.com");
            mailDTO.setFromName("Gaurav");
            mailDTO.setSubject("Gupta");
            AppUtil appUtil = new AppUtil();
            mailDTO.setHtml(appUtil.getUserSignUp(activationUrl + savedUser.getUuid()));
            emailService.sendEmail(mailDTO);
            modelAndView.addObject("success", "You have been registered successfully, please check your inbox to activate this account.");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }


    @RequestMapping(value = "/activate", method = RequestMethod.GET)
    public ModelAndView activate(@RequestParam String uuid) {
        ModelAndView modelAndView = new ModelAndView();
        UserCommand user = userService.getUserbyUUID(uuid);
        if (user != null) {
            if (userService.activate(user)) {
                modelAndView.addObject("activationSuccess", "Your profile has been activated. Please login to use your account");
                modelAndView.setViewName("login");
            } else {
                modelAndView.addObject("activationFailure", "Your profile couldn't be activated.");
                modelAndView.setViewName("login");
            }
        } else {
            modelAndView.addObject("activationExpire", "Your activation link has expired.");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
