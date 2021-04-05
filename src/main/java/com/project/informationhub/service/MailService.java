package com.project.informationhub.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	

    @Autowired
    public JavaMailSender javaMailSender;
    
    public void sendEmail(String to, String subject, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);

        msg.setSubject(subject);
        msg.setText(message);
       
        javaMailSender.send(msg);

    }
    
    public void sendEmail(List<String> to, String subject, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
       // msg.setTo(StringUtils.join(to, ","));
        String[] toArray = new String[to.size()];
        toArray = to.toArray(toArray);
        msg.setTo(toArray);
        msg.setSubject(subject);
        msg.setText(message);

        javaMailSender.send(msg);

    }

}
