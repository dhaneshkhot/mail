package com.dk.mail.controller;

import com.dk.mail.model.Mail;
import com.dk.mail.repository.MailRepository;
import com.dk.mail.service.MailServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/")
public class MainController {
    public static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MailServiceImpl mailService;
    @Autowired
    MailRepository mailRepository;

    
    @GetMapping("/send/mail")
    public ModelAndView home(Model model) {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("mail");
    	model.addAttribute("Mail", new Mail());
        return mv;
    }
        
    @PostMapping("/send/mail")
    public ModelAndView sendMail(Mail mail, UriComponentsBuilder ucBuilder, ModelMap map) {
   
        logger.info("Sending email : {}", mail);
        try {
        mailService.sendSimpleMessage(mail);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/send/mail").build().toUri());
        map.addAttribute("to",mail.getTo());
        return new ModelAndView("success","mail",mail);
        } catch (Exception e) {
        	return new ModelAndView("error","mail",mail);
        }
    }
    
    
}
