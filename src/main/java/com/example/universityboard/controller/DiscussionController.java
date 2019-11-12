package com.example.universityboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.universityboard.model.Discussion;
import com.example.universityboard.model.DiscussionComment;
import com.example.universityboard.model.DiscussionDTO;
import com.example.universityboard.service.DiscussionServiceImpl;

@RestController
@RequestMapping("/discussion")
public class DiscussionController {

	@Autowired
	private DiscussionServiceImpl discussionServiceImpl;

	@GetMapping("/getalldiscussions")
	public List<Discussion> getAllDiscussions() {
		return discussionServiceImpl.getAllDiscussion();
	}

	@PostMapping("/beginnewdiscussion")
	public Discussion addDiscussion(@RequestBody Discussion discussion) {
		return this.discussionServiceImpl.saveDiscussion(discussion);
	}

	@GetMapping("/getdiscussionbyauthonamer/{authorName}")
	public List<Discussion> getDiscussionByNameblog(@PathVariable String authorName) {
		return discussionServiceImpl.getDiscussionbyAuthorName(authorName);
	}

	@GetMapping("/getdiscussionbyId/{id}")
	public DiscussionDTO getDiscussionbyId(@PathVariable String id) {
		return discussionServiceImpl.getDiscussionbyId(id);
	}

	@PostMapping("/adddiscussioncomment")
	public DiscussionComment addDiscussionComment(@RequestBody DiscussionComment discussionComment) {
		return this.discussionServiceImpl.saveDiscussionComment(discussionComment);
	}
}
