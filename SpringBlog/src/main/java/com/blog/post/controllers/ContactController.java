package com.blog.post.controllers;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.post.service.EmailService;



@Controller
public class ContactController {
	
	private static final Logger logger = Logger.getLogger(ContactController.class);

	
	 @Autowired 
	 private EmailService emailService;
	
	
	@RequestMapping("/contact")
	public String contactForm(){
	
	return "contact";
	}
	
	

	@RequestMapping(value="/contact", method= RequestMethod.POST )
	public String sendEmail(@RequestParam("name") String name,
							@RequestParam("subject") String subject, 
							@RequestParam("message") String message,
							@RequestParam("phone") String  phone){
		
		logger.info("inside sendEmail method");
		
		
		try {
			emailService.sendSimpleMail("marietakarastoykova@gmail.com",subject, message + "\n Name: " +name + "\n Phone: " + phone);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return "contact";
	}
}
