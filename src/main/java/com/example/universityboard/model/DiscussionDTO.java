package com.example.universityboard.model;

import java.util.List;

public class DiscussionDTO {
	private String discussionId;
	private String discussionTitle;
	private String discussionAuthor;
	private String body;
	private List<DiscussionComment> comments;

	public String getDiscussionId() {
		return discussionId;
	}

	public void setDiscussionId(String discussionId) {
		this.discussionId = discussionId;
	}

	public String getDiscussionTitle() {
		return discussionTitle;
	}

	public void setDiscussionTitle(String discussionTitle) {
		this.discussionTitle = discussionTitle;
	}

	public String getDiscussionAuthor() {
		return discussionAuthor;
	}

	public void setDiscussionAuthor(String discussionAuthor) {
		this.discussionAuthor = discussionAuthor;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<DiscussionComment> getComments() {
		return comments;
	}

	public void setComments(List<DiscussionComment> comments) {
		this.comments = comments;
	}

	public DiscussionDTO(String discussionId, String discussionTitle, String discussionAuthor, String body,
			List<DiscussionComment> comments) {
		super();
		this.discussionId = discussionId;
		this.discussionTitle = discussionTitle;
		this.discussionAuthor = discussionAuthor;
		this.body = body;
		this.comments = comments;
	}

	

}
