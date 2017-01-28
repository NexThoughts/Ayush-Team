package com.nexthoughts.hackathon.ayush.team.domains;


import com.nexthoughts.hackathon.ayush.team.command.UserCommand;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @NotNull
    String uuid = UUID.randomUUID().toString();


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date dateCreated;

    @NotNull
    @Size(min = 3, max = 100)
    private String username;

    public User(String uuid, Boolean enabled) {
        this.uuid = uuid;
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;


    @OneToMany(mappedBy = "createdBy")
    private Set<Project> projectList;

    @OneToMany(mappedBy = "issueOwner")
    private Set<Issue> issueSet;


    @OneToMany(mappedBy = "assignee")
    private Set<IssueAssigned> issueAssignedSet;

    @OneToMany(mappedBy = "user")
    private Set<IssueState> issueStateSet;

    @OneToMany(mappedBy = "commentBy")
    private Set<IssueComment> issueCommentSet;

    private Boolean accountNonExpired = true;

    private Boolean accountNonLocked = true;

    private Boolean credentialsNonExpired = true;

    private Boolean enabled = false;


    public Set<IssueComment> getIssueCommentSet() {
        return issueCommentSet;
    }

    public void setIssueCommentSet(Set<IssueComment> issueCommentSet) {
        this.issueCommentSet = issueCommentSet;
    }

    public Set<IssueState> getIssueStateSet() {
        return issueStateSet;
    }

    public void setIssueStateSet(Set<IssueState> issueStateSet) {
        this.issueStateSet = issueStateSet;
    }

    public Set<IssueAssigned> getIssueAssignedSet() {
        return issueAssignedSet;
    }

    public void setIssueAssignedSet(Set<IssueAssigned> issueAssignedSet) {
        this.issueAssignedSet = issueAssignedSet;
    }

    public Set<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(Set<Project> projectList) {
        this.projectList = projectList;
    }

    public Set<Issue> getIssueSet() {
        return issueSet;
    }

    public void setIssueSet(Set<Issue> issueSet) {
        this.issueSet = issueSet;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Role> roles;

    public User() {
    }


    public User(UserCommand userCommand) {
        this.username = userCommand.getUsername();
        this.password = userCommand.getPassword();
        this.email = userCommand.getEmail();
        this.roles = userCommand.getRoles();
        this.firstName = userCommand.getFirstName();
        this.lastName = userCommand.getLastName();
    }


    public User(String username, String password, String email, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
