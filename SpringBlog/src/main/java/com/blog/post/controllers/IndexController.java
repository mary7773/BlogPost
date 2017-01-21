package com.blog.post.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.post.model.Post;
import com.blog.post.service.PostService;


@Controller
public class IndexController {
	
	@Autowired
	public PostService postService;
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping("/")
	public ModelAndView loadAllPosts(){
		
		List<Post> listPosts = postService.list();	
		int number = 3;
		ModelAndView model = new ModelAndView("listPosts");
		model.addObject("listPosts", listPosts);
		model.addObject("number", number);
		
		logger.error("loadAllPosts method is called");
		
		System.out.println("test");
		
	return model;
	}
	
	

	
	@RequestMapping(value="/increase", method= RequestMethod.POST)
	public ModelAndView increase(@RequestParam(value="number") int number){
	
	int num = number;
	List<Post> listPosts = postService.list();
	ModelAndView model = new ModelAndView("listPosts");
	model.addObject("listPosts", listPosts);
	model.addObject("number", num + 3);
	
	logger.info("increment method is called " + number);
		
	return model;
	
	}
	
	

}
