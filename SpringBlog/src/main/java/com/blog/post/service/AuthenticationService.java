package com.blog.post.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.blog.post.model.User;

public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private AuthorityService authorityService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.findUserByUsername(username);
		
		GrantedAuthority authority = new SimpleGrantedAuthority(authorityService.findUserByUsername(username).get(0));
		UserDetails userDetails = (UserDetails)new User(user.getUsername(), 
				user.getPassword(), Arrays.asList(authority));
		
		return userDetails;
	}

}
