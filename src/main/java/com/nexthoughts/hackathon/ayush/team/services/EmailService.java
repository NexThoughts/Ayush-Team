package com.nexthoughts.hackathon.ayush.team.services;


import com.nexthoughts.hackathon.ayush.team.DTO.MailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@PropertySource(value = {"classpath:application.properties"})
public class EmailService {

    @Value("${smtp.host}")
    private String host;

    @Value("${smtp.port}")
    private String port;

    @Value("${smtp.username}")
    private String username;

    @Value("${smtp.password}")
    private String password;

    public Boolean sendEmail(MailDTO mailDTO) {
        Boolean success = false;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        javax.mail.Session session = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailDTO.getFromEmailAddress(), mailDTO.getFromName()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mailDTO.getTo()));

            message.setSubject(mailDTO.getSubject());
            message.setContent(mailDTO.getHtml(), "text/html; charset=utf-8");
            Transport.send(message);
            success = true;
            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            success = false;
            throw new RuntimeException(e);
        } catch (Exception ex) {
            success = false;
            throw new RuntimeException(ex);
        }
        return success;

    }


}
