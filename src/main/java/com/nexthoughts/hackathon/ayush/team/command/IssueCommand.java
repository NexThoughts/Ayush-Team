package com.nexthoughts.hackathon.ayush.team.command;


import com.nexthoughts.hackathon.ayush.team.domains.*;
import com.nexthoughts.hackathon.ayush.team.enums.IssueType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class IssueCommand {

    private Long id;

    private String description;

    @NotNull(message = "Please mention the Type of Issue")
    private IssueType type;

    private Set<IssueAssigned> issueAssignedSet;

    private User issueOwner;

    private Project project;


    public IssueCommand() {
    }

    public IssueCommand(Long id, IssueType type, User issueOwner) {
        this.id = id;
        this.type = type;
        this.issueOwner = issueOwner;
    }

    public IssueCommand(Long id, String description, IssueType type, User issueOwner, Project project) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.issueOwner = issueOwner;
        this.project = project;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssueType getType() {
        return type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public Set<IssueAssigned> getIssueAssignedSet() {
        return issueAssignedSet;
    }

    public void setIssueAssignedSet(Set<IssueAssigned> issueAssignedSet) {
        this.issueAssignedSet = issueAssignedSet;
    }

    public User getIssueOwner() {
        return issueOwner;
    }

    public void setIssueOwner(User issueOwner) {
        this.issueOwner = issueOwner;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
