package com.nexthoughts.hackathon.ayush.team.enums;

/**
 * Created by abhinav on 28/1/17.
 */
public enum IssueStatus {
    SUBMITTED("Submitted"),
    IN_PROGRESS("In Progress"),
    RE_OPEN("Re open"),
    FIXED("Fixed");

    private String small;

    IssueStatus(String small) {
        this.small = small;
    }

    public String getSmall() {
        return small;
    }

}
