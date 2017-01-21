package com.blog.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.post.model.Authority;
import com.blog.post.model.Post;

@Service
public interface AuthorityService  {
	
	
	void save(Authority authority);
	void edit(Authority authority);
	void delete(Authority authority);
	Authority findUserById(Long  id);
	List<Authority> list();
	List<String> findUserByUsername(String username);

}
