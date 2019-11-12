package com.example.universityboard.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.universityboard.model.DiscussionComment;

public interface DiscussionCommentRepository extends MongoRepository<DiscussionComment, String> {

	List<DiscussionComment> findByIdIn(List<String> commentIds);

	List<DiscussionComment> findByDiscussionId(String discussionId);

}