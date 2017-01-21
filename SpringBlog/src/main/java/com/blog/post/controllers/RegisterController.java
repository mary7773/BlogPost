package com.blog.post.controllers;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.post.model.Authority;
import com.blog.post.model.User;
import com.blog.post.service.AuthorityService;
import com.blog.post.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(){
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerForm(@RequestParam("username") String username, 
								@RequestParam("password") String password, 
								@RequestParam("confirmPassword") String confirmPassword){
		
		if (password.equals(confirmPassword)) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setCreateDate(Calendar.getInstance());
			user.setEnabled(true);
			userService.save(user);
			
			Authority authority = new Authority();
			authority.setAuthority("ADMIN");
			authority.setUsername(username);
			authorityService.save(authority);
			
			Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			
		}
		
		return "redirect:/";
	}



}
