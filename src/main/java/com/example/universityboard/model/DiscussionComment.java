package com.example.universityboard.model;

import org.springframework.data.annotation.Id;

public class DiscussionComment {

	@Id
	private String id;
	private String commentDetail;
	private String discussionId;
	private String userId;
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommentDetail() {
		return commentDetail;
	}

	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}

	public String getDiscussionId() {
		return discussionId;
	}

	public void setDiscussionId(String discussionId) {
		this.discussionId = discussionId;
	}

	

}