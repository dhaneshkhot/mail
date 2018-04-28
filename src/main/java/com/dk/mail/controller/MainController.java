package com.dk.mail.controller;

import com.dk.mail.model.Mail;
import com.dk.mail.repository.MailRepository;
import com.dk.mail.service.MailServiceImpl;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/send")
public class MainController {
    public static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MailServiceImpl mailService;
    @Autowired
    MailRepository mailRepository;

    
    @GetMapping("/mail")
    public ModelAndView home(Model model) {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("mail");
    	model.addAttribute("Mail", new Mail());
        return mv;
    }
    
//    @RequestMapping(value = "/send/mail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public String compose(Mail mail, UriComponentsBuilder ucBuilder) {
//        logger.info("Sending email : {}", mail);
//        mailService.sendSimpleMessage(mail);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/send/mail").build().toUri());
//        return "success";
//    }
    

    
    @PostMapping("/mail")
    public ResponseEntity<Object> sendMail(@RequestBody Mail mail) {
    	
        Mail sentMailSaved = mailRepository.save(mail);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//        map.addAttribute("to", mail.getTo());
//        logger.info("Sending email : {}", mail);
//        mailService.sendSimpleMessage(mail);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/send/mail").build().toUri());
//        return new ModelAndView("success","sentmail",sentMailSaved);
        return ResponseEntity.created(location).build();
    }
    
}
