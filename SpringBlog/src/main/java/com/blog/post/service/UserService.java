package com.blog.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.post.model.User;

@Service
public interface UserService {
	
	void save(User user);
	void edit(User user);
	void delete(User user);
	User findUserById(Long  id);
	List<User> list();
	User findUserByUsername(String username);

}
