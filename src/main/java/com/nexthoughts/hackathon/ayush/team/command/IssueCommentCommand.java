package com.nexthoughts.hackathon.ayush.team.command;


import com.nexthoughts.hackathon.ayush.team.domains.Issue;
import com.nexthoughts.hackathon.ayush.team.domains.User;

public class IssueCommentCommand {

    private Long id;

    private Issue onIssue;

    private User commentBy;

    private String comment;

    public IssueCommentCommand() {
    }

    public IssueCommentCommand(Long id, Issue onIssue, User commentBy, String comment) {
        this.id = id;
        this.onIssue = onIssue;
        this.commentBy = commentBy;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Issue getOnIssue() {
        return onIssue;
    }

    public void setOnIssue(Issue onIssue) {
        this.onIssue = onIssue;
    }

    public User getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(User commentBy) {
        this.commentBy = commentBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
