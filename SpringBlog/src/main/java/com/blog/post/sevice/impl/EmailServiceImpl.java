package com.blog.post.sevice.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.blog.post.service.EmailService;

public class EmailServiceImpl implements EmailService{
	

	@Autowired 
    private JavaMailSender mailSender;
    
    public void sendSimpleMail(String to, String subject, String body) throws MessagingException {
       
        
        // Prepare message using a Spring helper
    	MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setText(body, true);
        this.mailSender.send(mimeMessage);

    }


}
