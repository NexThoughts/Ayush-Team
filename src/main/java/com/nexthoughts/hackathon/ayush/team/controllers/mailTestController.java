package com.nexthoughts.hackathon.ayush.team.controllers;


import com.nexthoughts.hackathon.ayush.team.DTO.AppUtil;
import com.nexthoughts.hackathon.ayush.team.DTO.MailDTO;
import com.nexthoughts.hackathon.ayush.team.services.EmailService;
import com.nexthoughts.hackathon.ayush.team.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class mailTestController {
    @Autowired
    EmailService emailService;

    @Value(value = "login.error")
    private String error;

    @Value(value = "logout.success")
    private String logout;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public ModelAndView sendEmail() {
        System.out.print("sssssssssssssssssssssssssssssssssssssssss6666666666666666666666666666666666666");
        MailDTO mailDTO = new MailDTO();
        mailDTO.setTo("nakul@nexthoughts.com");
        mailDTO.setFromEmailAddress("gaurav.gupta@nexthoughts.com");
        mailDTO.setFromName("Gauri");
        mailDTO.setSubject("Hellloo");
        AppUtil appUtil= new AppUtil();
        mailDTO.setHtml(appUtil.getContent("http://www.google.com"));
        emailService.sendEmail(mailDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userrrrrrrrrrrrrrrrrrrrr");
        return modelAndView;
    }


}
