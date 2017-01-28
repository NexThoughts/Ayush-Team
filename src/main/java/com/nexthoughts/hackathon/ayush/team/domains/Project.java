package com.nexthoughts.hackathon.ayush.team.domains;

import com.nexthoughts.hackathon.ayush.team.command.ProjectCO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    public void setName(String name) {
        this.name = name;
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

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "createdBy=" + createdBy +
                ", id=" + id +
                ", lastUpdated=" + lastUpdated +
                ", dateCreated=" + dateCreated +
                ", issueSet=" + issueSet +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (!createdBy.equals(project.createdBy)) return false;
        if (!id.equals(project.id)) return false;
        if (!lastUpdated.equals(project.lastUpdated)) return false;
        if (!dateCreated.equals(project.dateCreated)) return false;
        if (!issueSet.equals(project.issueSet)) return false;
        if (!name.equals(project.name)) return false;
        return description.equals(project.description);

    }

    @Override
    public int hashCode() {
        int result = createdBy.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + lastUpdated.hashCode();
        result = 31 * result + dateCreated.hashCode();
        result = 31 * result + issueSet.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
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
