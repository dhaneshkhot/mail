package com.dk.mail.controller;

import com.dk.mail.model.Mail;
import com.dk.mail.service.MailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class MainController {
    public static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MailServiceImpl mailService;
    
//    @RequestMapping(value = "api/mail", method = RequestMethod.GET)
//    public String compose(Model model) {
//        model.addAttribute("pageTitle","Welcome to Compose Email");
//        return "api/mail";
//    }
    
    @RequestMapping(value = "/send/mail", method = RequestMethod.GET)
    public String compose(Model model) {
        model.addAttribute("Mail", new Mail());
        return "mail";
    }
    
    @RequestMapping(value = "/send/mail", method = RequestMethod.POST)
    public ResponseEntity<?> compose(@RequestBody Mail mail, UriComponentsBuilder ucBuilder) {
        logger.info("Sending email : {}", mail);
        mailService.sendSimpleMessage(mail);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/send/mail").build().toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
}
