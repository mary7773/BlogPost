package com.blog.post.repository;

import org.springframework.data.repository.CrudRepository;

import com.blog.post.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	
	public User findUserByUsername(String username);
}
