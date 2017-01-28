package com.nexthoughts.hackathon.ayush.team.services;

import com.nexthoughts.hackathon.ayush.team.command.ProjectCO;
import com.nexthoughts.hackathon.ayush.team.domains.Project;
import com.nexthoughts.hackathon.ayush.team.domains.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectService {
    @Autowired
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

    public void create(ProjectCO projectCO, org.springframework.security.core.userdetails.User springSecurityUser) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        String username = springSecurityUser.getUsername();
        com.nexthoughts.hackathon.ayush.team.domains.User user = userService.getUserbyUsername(username);
        Project project = new Project(user, projectCO);
        session.saveOrUpdate(project);
        transaction.commit();
        session.close();

    }

    public List<ProjectCO> list(org.springframework.security.core.userdetails.User springSecurityUser) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        String username = springSecurityUser.getUsername();
        com.nexthoughts.hackathon.ayush.team.domains.User user = userService.getUserbyUsername(username);
        Criteria criteria = session.createCriteria(Project.class);
        List<Project> projectList = criteria.list();
        List<ProjectCO> projectCOList = new ArrayList<ProjectCO>();
        ProjectCO projectCO = null;
        for (Project project : projectList) {
            projectCO = new ProjectCO(project);
            projectCOList.add(projectCO);

        }
        transaction.commit();
        session.close();
        return projectCOList;
    }

    public Project read(long id) {
        Session session = getSession();
        Project project = (Project) session.get(Project.class, new Long(id));
        session.close();
        return project;
    }
    public Project update(ProjectCO projectCO){
        Session session = getSession();
        Transaction transaction=session.beginTransaction();
        Project project = (Project) session.get(Project.class, new Long(projectCO.getId()));
        project.setName(projectCO.getName());
        project.setDescription(projectCO.getDescription());
        session.saveOrUpdate(project);
        transaction.commit();
        session.close();
        return  project;
    }
}
