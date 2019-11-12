package com.example.universityboard.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.universityboard.model.BlogDetails;

public interface BlogRepository extends MongoRepository<BlogDetails, String> {

	BlogDetails findByBlogTitle(String blogTitle);
	
	List<BlogDetails> findByBlogAuthor(String blogAuthor);
}