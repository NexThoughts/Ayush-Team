package com.nexthoughts.hackathon.ayush.team.controllers;

import com.nexthoughts.hackathon.ayush.team.command.ProjectCO;
import com.nexthoughts.hackathon.ayush.team.domains.Project;
import com.nexthoughts.hackathon.ayush.team.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("create");
        return modelAndView;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView save(@Valid ProjectCO projectCO, BindingResult result) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView=new ModelAndView();
        if(result.hasErrors()){
            modelAndView.setViewName("create");
        }
        else{
            projectService.create(projectCO,user);
            modelAndView.setViewName("create");
        }
        return modelAndView;
    }
}
