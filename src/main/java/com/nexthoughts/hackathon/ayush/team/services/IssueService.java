package com.nexthoughts.hackathon.ayush.team.services;

import com.nexthoughts.hackathon.ayush.team.command.IssueCommand;
import com.nexthoughts.hackathon.ayush.team.domains.Issue;
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
public class IssueService {

    private SessionFactory sessionFactory;

    @Autowired
    UserService userService;

    @Autowired
    public IssueService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    public void createIssue(IssueCommand issueCommand, org.springframework.security.core.userdetails.User springSecurityUser) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        String username = springSecurityUser.getUsername();
        com.nexthoughts.hackathon.ayush.team.domains.User user = userService.getUserbyUsername(username);
        Project project = (Project) session.get(Project.class, issueCommand.getProjectId());
        Issue issue = new Issue(issueCommand, user, project);
        session.save(issue);
        transaction.commit();
        session.close();
    }

    public List<IssueCommand> list(org.springframework.security.core.userdetails.User springSecurityUser, Long projectId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        String username = springSecurityUser.getUsername();
        com.nexthoughts.hackathon.ayush.team.domains.User user = userService.getUserbyUsername(username);
        Project project = (Project) session.get(Project.class, projectId);
        Criteria criteria = session.createCriteria(Issue.class);
        Criteria projCriteria = criteria.createCriteria("project");
        projCriteria.add(Restrictions.eq("id", project.getId()));
        List<Issue> issueList = criteria.list();
        List<IssueCommand> issueCommandList = new ArrayList<IssueCommand>();
        IssueCommand issueCommand = null;
        for (Issue issue : issueList) {
            issueCommand = new IssueCommand(issue);
            issueCommandList.add(issueCommand);

        }
        transaction.commit();
        session.close();
        return issueCommandList;
    }

    public void updateIssue(IssueCommand issueCommand, org.springframework.security.core.userdetails.User springSecurityUser) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        String username = springSecurityUser.getUsername();
        com.nexthoughts.hackathon.ayush.team.domains.User user = userService.getUserbyUsername(username);
        Project project = (Project) session.get(Project.class, issueCommand.getProjectId());
        Issue issue = new Issue(issueCommand, user, project);
    }
}
