package com.blog.post.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.post.model.User;
import com.blog.post.service.UserService;

@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		
		logger.info("Login page invoked");
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String goLogin(@RequestParam("username") String username,@RequestParam("password") String password ){
	
		User user = userService.findUserByUsername(username);
		
		System.out.println(user.getUsername());
		
		logger.info("==============User value " + user.getUsername());
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		SecurityContextHolder.getContext().setAuthentication(null);		
		return "login";
	}
	


}
