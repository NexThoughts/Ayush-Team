package com.nexthoughts.hackathon.ayush.team.domains;


import com.nexthoughts.hackathon.ayush.team.enums.IssueStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class IssueState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date dateCreated;
    @NotNull
    @Enumerated(EnumType.STRING)
    private IssueStatus status;


    @NotNull
    @ManyToOne
    private User user;
    @NotNull

    @ManyToOne
    private Issue issue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
