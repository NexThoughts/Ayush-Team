package com.nexthoughts.hackathon.ayush.team.DTO;


public class MailDTO {
    private String to;
    private String html;
    private String subject;
    private String fromEmailAddress;
    private String fromName;

    public MailDTO(String to, String html, String subject, String fromEmailAddress, String fromName) {
        this.to = to;
        this.html = html;
        this.subject = subject;
        this.fromEmailAddress = fromEmailAddress;
        this.fromName = fromName;

    }

    public MailDTO() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

}
