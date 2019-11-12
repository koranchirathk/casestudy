package com.example.universityboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.universityboard.model.BlogDetails;

public interface BlogRepository extends MongoRepository<BlogDetails, String> {

	BlogDetails findByBlogTitle(String blogTitle);
	
	BlogDetails findByBlogAuthor(String blogAuthor);
}