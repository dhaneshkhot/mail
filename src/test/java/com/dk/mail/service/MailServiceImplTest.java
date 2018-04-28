package com.dk.mail.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dk.mail.model.Mail;

@Component
public class MailServiceImplTest{
    @Autowired
    MailServiceImpl mailService;
    
    private String from = "dhaneshkhot1@gmail.com";
    private String to = "dhanesh.khot@gmail.com";
    private String subject = "Test Subject";
    private String content = "Test Message";

    @Test
    public void sendSimpleMessage(){
    	Mail mail = new Mail(to, from, subject, content);
    	mailService.sendSimpleMessage(mail);
   	
    }
}
