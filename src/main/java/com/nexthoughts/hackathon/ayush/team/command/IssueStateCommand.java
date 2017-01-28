package com.nexthoughts.hackathon.ayush.team.command;


import com.nexthoughts.hackathon.ayush.team.domains.Issue;
import com.nexthoughts.hackathon.ayush.team.domains.User;
import com.nexthoughts.hackathon.ayush.team.enums.IssueStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class IssueStateCommand {

    private Long id;

    @NotNull
    @Size(min = 5, max = 25, message = "Please provide a valid and meaningful name to the State of Issue")
    private String name;

    private IssueStatus status;

    private User user;

    @NotNull
    private Issue issue;

    public IssueStateCommand() {
    }

    public IssueStateCommand(Long id, String name, IssueStatus status, User user, Issue issue) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.user = user;
        this.issue = issue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }
}
