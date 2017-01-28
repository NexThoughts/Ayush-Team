package com.nexthoughts.hackathon.ayush.team.command;


import com.nexthoughts.hackathon.ayush.team.domains.Role;
import com.nexthoughts.hackathon.ayush.team.domains.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserCommand {

    private Long id;

    @NotNull(message = "Username should not be empty")
    @Size(min = 3, max = 50)
    private String username;

    @NotNull(message = "Password should not be empty")
    @Size(min = 8, max = 50)
    private String password;

    @NotNull(message = "Confirm Password should not be empty")
    @Size(min = 8, max = 50)
    private String confirmPassword;

    @NotNull(message = "Email should not be empty")
    @Size(min = 8, max = 50)
    private String email;

    @NotNull(message = "First name should not be empty")
    @Size(min = 5, max = 30)
    private String firstName;

    @NotNull(message = "Last name should not be empty")
    @Size(min = 5, max = 30)
    private String lastName;

    private String uuid;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public UserCommand(Long id, String username, String password, String email, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
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

    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public UserCommand() {
    }


    public UserCommand(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.uuid = user.getUuid();

    }


    public UserCommand(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserCommand(Long id, String username, String password, String email, Set roles) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
