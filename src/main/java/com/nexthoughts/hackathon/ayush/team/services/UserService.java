package com.nexthoughts.hackathon.ayush.team.services;

import com.nexthoughts.hackathon.ayush.team.command.UserCommand;
import com.nexthoughts.hackathon.ayush.team.domains.User;
import com.nexthoughts.hackathon.ayush.team.services.springsecurity.PasswordEncoderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    @Autowired
    PasswordEncoderService encoderService;

    private SessionFactory sessionFactory;

    @Autowired
    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }


    public long create(UserCommand userCommand) {
        User user = new User(userCommand);
        user.setPassword(encoderService.encode(userCommand.getPassword()));
        getSession().save(user);
        getSession().close();
        return user.getId();
    }


    public User read(Long id) {
        return (User) getSession().get(User.class, id);
    }

    public User getUserbyUsername(String username) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username)).uniqueResult();

    }

    public UserCommand getUserbyUUID(String uuid) {
        User user = (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("uuid", uuid)).uniqueResult();
        if (user == null) {
            return null;
        } else {
            UserCommand userCommand = new UserCommand(user);
            getSession().close();
            return userCommand;
        }
    }

    public boolean activate(UserCommand user) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        User user1 = (User) session.get(User.class, user.getId());
        user1.setEnabled(true);
        user1.setUuid(UUID.randomUUID().toString());
        session.saveOrUpdate(user1);
        tx.commit();
        session.flush();
        session.close();
        return true;
    }

    public List<UserCommand> list() {
        List<User> userList = getSession().createCriteria(User.class).list();
        List<UserCommand> userCommandList = new ArrayList<UserCommand>();
        UserCommand userCommand = null;
        for (User user : userList) {
            userCommand = new UserCommand(user);
            userCommandList.add(userCommand);
        }
        getSession().close();
        return userCommandList;
    }
}
