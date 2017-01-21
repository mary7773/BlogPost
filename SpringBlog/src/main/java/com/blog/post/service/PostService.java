package com.blog.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.post.model.Post;
import com.blog.post.model.User;


@Service
public interface PostService {
	
	void save(Post post);
	void edit(Post post);
	void delete(Post post);
	Post findPostById(Long  id);
	List<Post> list();

}
