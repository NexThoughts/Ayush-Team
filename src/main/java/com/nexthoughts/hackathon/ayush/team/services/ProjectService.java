package com.nexthoughts.hackathon.ayush.team.services;

import com.nexthoughts.hackathon.ayush.team.command.ProjectCO;
import com.nexthoughts.hackathon.ayush.team.domains.Project;
import com.nexthoughts.hackathon.ayush.team.domains.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectService {
    private SessionFactory sessionFactory;
   @Autowired
    private UserService userService;
    @Autowired
    public ProjectService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }
    public void create(ProjectCO projectCO, org.springframework.security.core.userdetails.User springSecurityUser){
        Session session=getSession();
        Transaction transaction=session.beginTransaction();
        String username=springSecurityUser.getUsername();
        com.nexthoughts.hackathon.ayush.team.domains.User user=userService.getUserbyUsername(username);
        Project project=new Project(user,projectCO);
        session.save(project);
        transaction.commit();
        session.close();

    }
}
