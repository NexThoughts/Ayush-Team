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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project/create");
        return modelAndView;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView save(@Valid ProjectCO projectCO, BindingResult result) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("project/create");
        } else {
            projectService.create(projectCO, user);
            modelAndView.setViewName("redirect:list");
        }
        return modelAndView;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        List<ProjectCO> projectList = projectService.list(user);
        modelAndView.addObject("projectList", projectList);
        modelAndView.setViewName("project/list");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long identity) {

        Project project = projectService.read(identity);
        ProjectCO projectCO=new ProjectCO(project);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project/edit");
        modelAndView.addObject("project", projectCO);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView update(/*@Valid*/ ProjectCO projectCO/*, BindingResult result*/) {
        ModelAndView modelAndView = new ModelAndView();

//        if(result.hasErrors()){
            modelAndView.setViewName("project/edit");
//        }
//        else{
            modelAndView.setViewName("project/list");
//        }
        Project project = projectService.update(projectCO);
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }
}
