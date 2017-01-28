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
    private String type;

    private Long projectId;

    public IssueCommand() {
    }

    public IssueCommand(Issue issue) {
        this.description = issue.getDescription();
        this.type = issue.getType();
        this.projectId = issue.getProject().getId();
    }

    public IssueCommand(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public IssueCommand(Long id, String description, String type) {
        this.id = id;
        this.description = description;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
