package com.dk.mail.service;


import com.dk.mail.model.Mail;
import com.dk.mail.repository.MailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MailServiceImpl implements MailService{
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    MailRepository mailRepository;

    @Transactional
    public void sendSimpleMessage(final Mail mail){
    	mailRepository.save(mail);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        message.setTo(mail.getTo());
        message.setFrom(mail.getFrom());

        emailSender.send(message);
    }
}
