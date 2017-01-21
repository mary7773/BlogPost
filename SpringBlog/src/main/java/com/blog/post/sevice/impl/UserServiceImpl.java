package com.blog.post.sevice.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.post.controllers.IndexController;
import com.blog.post.model.Post;
import com.blog.post.model.User;
import com.blog.post.repository.UserRepository;
import com.blog.post.service.UserService;

public class UserServiceImpl implements UserService {
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void save(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void edit(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void delete(User user) {
		userRepo.delete(user);
		
	}

	@Override
	public User findUserById(Long id) {		
		return userRepo.findOne(id);
	}

	@Override
	public List<User> list() {
		List<User> users = (List<User>) userRepo.findAll();
		return users;
	}

	@Override
	public User findUserByUsername(String username) {
		
		logger.debug("============User" + userRepo.findUserByUsername(username).getUsername());
	
		return userRepo.findUserByUsername(username);
	}

}
