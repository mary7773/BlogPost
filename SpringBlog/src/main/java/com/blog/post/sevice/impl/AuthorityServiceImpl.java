package com.blog.post.sevice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.post.model.Authority;
import com.blog.post.repository.AuthorityRepository;
import com.blog.post.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	private AuthorityRepository authorityRepo;

	@Override
	public void save(Authority authority) {
		authorityRepo.save(authority);
		
	}

	@Override
	public void edit(Authority authority) {
		authorityRepo.save(authority);		
	}

	@Override
	public void delete(Authority authority) {
		authorityRepo.delete(authority);
		
	}

	@Override
	public Authority findUserById(Long id) {
		return 	authorityRepo.findOne(id);
	}

	@Override
	public List<Authority> list() {	
		List<Authority> list = (List<Authority>) authorityRepo.findAll();		
		return list;
	}

	@Override
	public List<String> findUserByUsername(String username) {
		
		List<Authority> list = (List<Authority>) authorityRepo.findAll();
		
		List<String> roles = new ArrayList<>();
		
		for (Authority authority : list) {
			
			if (authority.getUsername().equals(username)) {
				
				roles.add(authority.getAuthority());
			}
			
		}		
		
		return roles;
	}

}
