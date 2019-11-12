package com.example.universityboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universityboard.model.Discussion;
import com.example.universityboard.model.DiscussionComment;
import com.example.universityboard.model.DiscussionDTO;
import com.example.universityboard.repository.DiscussionCommentRepository;
import com.example.universityboard.repository.DiscussionRepository;

@Service
public class DiscussionServiceImpl {

	@Autowired
	DiscussionRepository discussionRepository;

	@Autowired
	DiscussionCommentRepository discussionCommentRepository;

	public List<Discussion> getAllDiscussion() {
		return discussionRepository.findAll();
	}

	public Discussion saveDiscussion(Discussion discussion) {
		return this.discussionRepository.save(discussion);

	}

	public List<Discussion> getDiscussionbyAuthorName(String discussionAuthor) {
		return discussionRepository.findByDiscussionAuthor(discussionAuthor);
	}

	public DiscussionDTO getDiscussionbyId(String discussionId) {
		Discussion discussion = discussionRepository.findById(discussionId).orElse(null);
		List<DiscussionComment> comments = discussionCommentRepository.findByDiscussionId(discussion.getDiscussionId());
		DiscussionDTO discussionDTO = new DiscussionDTO(discussionId, discussion.getDiscussionTitle(),
				discussion.getDiscussionAuthor(), discussion.getBody(), comments);
		return discussionDTO;
	}

	public DiscussionComment saveDiscussionComment(DiscussionComment discussionComment) {
		return discussionCommentRepository.save(discussionComment);
	}
}
