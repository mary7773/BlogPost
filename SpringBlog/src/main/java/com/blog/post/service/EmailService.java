package com.blog.post.service;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

	void sendSimpleMail(String to, String subject, String body) throws MessagingException;

}
