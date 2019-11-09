package com.example.universityboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universityboard.model.GroupDetails;
import com.example.universityboard.repository.AdminRepository;

@Service
public class AdminServiceImpl {

	@Autowired
	AdminRepository adminRepository;

	public GroupDetails saveGroup(GroupDetails groupDetails) {
		return this.adminRepository.save(groupDetails);
	}

	public GroupDetails updateGroup(GroupDetails groupDetails) {
		GroupDetails userdetail = adminRepository.findByGroupName(groupDetails.getGroupName());
		userdetail.setType(groupDetails.getType());
		userdetail.setMembers(groupDetails.getMembers());
		return this.adminRepository.save(groupDetails);
	}

	public void deleteGroup(String groupName) {
		adminRepository.deleteById(groupName);
	}

	public GroupDetails getGroupByName(String groupName) {
		return adminRepository.findByGroupName(groupName);
	}
	
	public List<GroupDetails> getAllGroups() {
		return adminRepository.findAll();
	}

}
