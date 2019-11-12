package com.example.universityboard.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.universityboard.model.Discussion;

public interface DiscussionRepository extends MongoRepository<Discussion, String> {

	Discussion findByDiscussionTitle(String discussionTitle);

	List<Discussion> findByDiscussionAuthor(String discussionAuthor);
}