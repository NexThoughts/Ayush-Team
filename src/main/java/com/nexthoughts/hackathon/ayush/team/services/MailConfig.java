package com.nexthoughts.hackathon.ayush.team.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = {"classpath:application.properties"})
public class MailConfig {

    @Value("${smtp.host}")
    private String host;

    @Value("${smtp.port}")
    private String port;

    @Value("${smtp.username}")
    private String username;

    @Value("${smtp.password}")
    private String password;

    @Override
    public String toString() {
        return "MailConfig{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailConfig that = (MailConfig) o;

        if (!host.equals(that.host)) return false;
        if (!port.equals(that.port)) return false;
        if (!username.equals(that.username)) return false;
        return password.equals(that.password);

    }

    @Override
    public int hashCode() {
        int result = host.hashCode();
        result = 31 * result + port.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
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

    public MailConfig() {

    }


}
