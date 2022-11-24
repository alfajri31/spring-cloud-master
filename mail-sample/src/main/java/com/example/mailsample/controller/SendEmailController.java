package com.example.mailsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class SendEmailController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("send")
    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo("muhammad.fajri@sinarmasmsiglife.co.id");
        message.setSubject("test subject");
        message.setText("lorem ipsum dolor sit amet");
        emailSender.send(message);
    }
}
