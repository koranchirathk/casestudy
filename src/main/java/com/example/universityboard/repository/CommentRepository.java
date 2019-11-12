package com.example.universityboard.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.universityboard.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

	List<Comment> findByIdIn(List<String> commentIds);
	List<Comment> findByBlogId(String blogId);

}