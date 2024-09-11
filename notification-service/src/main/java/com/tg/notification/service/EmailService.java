package com.tg.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("tgeeteyt@gmail.com");
        message.setFrom("testisthebest2000@gmail.com"); // Sender's email
        message.setSubject("test");
        message.setText("No test required");
        javaMailSender.send(message);
    }
}
