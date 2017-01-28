package com.nexthoughts.hackathon.ayush.team.DTO;


public class MailDTO {
    private String to;
    private String html;
    private String subject;
    private String fromEmailAddress;
    private String fromName;
    private String userName;

    public MailDTO(String to, String html, String subject, String fromEmailAddress, String fromName, String userName, String password, String host, String port) {
        this.to = to;
        this.html = html;
        this.subject = subject;
        this.fromEmailAddress = fromEmailAddress;
        this.fromName = fromName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    private String password;
    private String host;
    private String port;
}
