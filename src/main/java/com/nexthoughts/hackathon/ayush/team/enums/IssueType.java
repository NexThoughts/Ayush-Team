package com.nexthoughts.hackathon.ayush.team.enums;


public enum IssueType {

    BUG("bug"),

    TASK("Task"),

    Feature("Feature");

    private String small;

    IssueType(String small) {
        this.small = small;
    }

    public String getSmall() {
        return small;
    }

}
