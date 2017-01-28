package com.nexthoughts.hackathon.ayush.team.domains;

import com.nexthoughts.hackathon.ayush.team.enums.IssueType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date dateCreated;


    @Size(min = 3, max = 50)
    private String description;

    @Enumerated(EnumType.STRING)
    private IssueType type;

    @OneToMany(mappedBy = "issue")
    private Set<IssueAssigned> issueAssignedSet;

    @NotNull
    @ManyToOne
    private User issueOwner;

    @NotNull
    @ManyToOne
    private Project project;

    @OneToMany(mappedBy = "issue")
    private Set<IssueState> issueStateSet;

    @OneToMany(mappedBy = "onIssue")
    private Set<IssueComment> issueCommentSet;

    public Long getId() {
        return id;
    }

    public Issue() {
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
