package com.blog.post.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.post.model.Post;
import com.blog.post.model.User;
import com.blog.post.service.PostService;
import com.blog.post.service.UserService;

@Controller
public class PostController {
	
	private static final Logger logger = Logger.getLogger(PostController.class);
	
	@Autowired
	public PostService postService;
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/savePost", method= RequestMethod.POST)
	public String save(@RequestParam(value="title") String title, @RequestParam(value="content") String content){
	
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findUserByUsername(username);
		logger.debug("================Username is " + user.getUsername());
		Post post = new Post();
		post.setCreateDate(new Date());
		post.setTitle(title);
		post.setText(content);
		post.setUser(user);
		
		System.out.println("================Username is " + user.getUsername());
		postService.save(post);
		
	return "redirect:/";
	
	}

	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		Long postId = Long.parseLong(request.getParameter("id"));
		Post post = postService.findPostById(postId);
		ModelAndView model = new ModelAndView("post");
		model.addObject("post", post);
		return model;		
	}
}
