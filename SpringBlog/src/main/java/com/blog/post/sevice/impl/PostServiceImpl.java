package com.blog.post.sevice.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.blog.post.model.Post;
import com.blog.post.model.User;
import com.blog.post.repository.PostRepository;
import com.blog.post.service.PostService;

public class PostServiceImpl implements PostService{
	
	private static final Logger logger = Logger.getLogger(PostServiceImpl.class);
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void save(Post post) {
		
		logger.info("PostServiceImpl save metod is called");
		
		postRepository.save(post);
		
	}

	@Override
	public void edit(Post post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Post post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Post findPostById(Long  id) {		
	return postRepository.findOne(id);
	}

	@Override
	public List<Post> list() {	
		return (List<Post>) postRepository.findAll() ;
	}

}
