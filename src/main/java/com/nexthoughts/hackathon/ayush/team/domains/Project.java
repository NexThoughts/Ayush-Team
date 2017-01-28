package com.nexthoughts.hackathon.ayush.team.domains;

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

    public Project() {
    }

    @Size(min = 3, max = 50)

    private String description;
}
