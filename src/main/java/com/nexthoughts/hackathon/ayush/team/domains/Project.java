package com.nexthoughts.hackathon.ayush.team.domains;

import com.nexthoughts.hackathon.ayush.team.command.ProjectCO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.criterion.Restrictions;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity(name = "project")
public class Project {
    @NotNull
    @ManyToOne
    private User createdBy;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public String getName() {
        return name;
    }

    public Set<Issue> getIssueSet() {
        return issueSet;
    }

    public void setIssueSet(Set<Issue> issueSet) {
        this.issueSet = issueSet;
    }

    @NotNull
    @Size(min=3,max=20)
    private String name;

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date dateCreated;

    @OneToMany(mappedBy = "project")
    private Set<Issue> issueSet;


    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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



    public void setName(String name) {
        this.name = name;
    }

    public Project() {
    }

    @NotNull
    @Size(min = 3, max = 50)
    private String description;

    public Project(User user, ProjectCO projectCO){
        this.name=projectCO.getName();
        this.createdBy=user;
        this.description=projectCO.getDescription();
    }
}
