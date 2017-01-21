package com.blog.post.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blog.post.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
