package com.nexthoughts.hackathon.ayush.team.controllers;

import com.nexthoughts.hackathon.ayush.team.command.IssueCommand;
import com.nexthoughts.hackathon.ayush.team.domains.Issue;
import com.nexthoughts.hackathon.ayush.team.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/issue")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class IssueController {

    @Autowired
    IssueService issueService;

    @Value(value = "login.error")
    private String error;

    @Value(value = "logout.success")
    private String logout;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(Long projectId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        List<IssueCommand> issueList = issueService.list(user, projectId);
        modelAndView.setViewName("issue/list");
        modelAndView.addObject("issueList", issueList);
        return modelAndView;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("issue/create");
        return modelAndView;
    }


    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView save(@Valid IssueCommand issueCommand, BindingResult result) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("/issue/create");
        } else {
            issueService.createIssue(issueCommand, user);
            modelAndView.setViewName("/issue/list");
        }
        return modelAndView;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/issue/list");
        return modelAndView;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView update(@Valid IssueCommand issueCommand, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (result.hasErrors()) {
            modelAndView.setViewName("issue/edit");
        } else {
            //        TODO Update Issue
            issueService.createIssue(issueCommand, user);
            modelAndView.setViewName("");
        }
        return modelAndView;
    }
}
