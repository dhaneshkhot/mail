package com.dk.mail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dk.mail.model.Mail;
import com.dk.mail.repository.MailRepository;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    MailRepository mailRepository;
	
//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String home(Model model){
//        model.addAttribute("pageTitle","Welcome to Application");
//        return "home";
//    }
    
// // Get All Mails
//    @GetMapping("sentmails")
//    public List<Mail> getAllSentMails() {
//        return mailRepository.findAll();
//    }
    
    
    // Get All Mails
    @GetMapping("/")
    public ModelAndView home(ModelMap map) {
    	List<Mail> sentmails = mailRepository.findAll();
    	map.addAllAttributes(sentmails);
        return new ModelAndView("home","sentmails",sentmails);
    }
    
    // Get All Mails
    @GetMapping("/sentmails")
    public ModelAndView getAllSentMails(ModelMap map) {
    	List<Mail> sentmails = mailRepository.findAll();
    	map.addAllAttributes(sentmails);
        return new ModelAndView("sentmails","sentmails",sentmails);
    }

}
