package com.nexthoughts.hackathon.ayush.team.command;


import com.nexthoughts.hackathon.ayush.team.domains.Project;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ProjectCO {

    @NotNull
    @Size(min=3,max = 50,message = "size must be between 3 and 50")
    private String name;

    private long id;
    private String description;

    public String getDescription() {
        return description;
    }

    private Date dateCreated;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectCO() {

    }
    public ProjectCO(Project project){
        this.description=project.getDescription();
        this.name=project.getName();
        this.dateCreated=project.getDateCreated();
        this.id=project.getId();
    }

}