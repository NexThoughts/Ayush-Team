package com.nexthoughts.hackathon.ayush.team.command;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectCO {

    @NotNull
    @Size(min=3,max = 50,message = "size must be between 3 and 50")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectCO() {

    }
}