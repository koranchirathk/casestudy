package com.example.universityboard.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class GroupDetails {
	@Id
	private String groupName;
	private String type;
	private List<String> members;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String userName) {
		this.groupName = userName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

}
