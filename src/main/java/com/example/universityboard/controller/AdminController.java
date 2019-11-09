package com.example.universityboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.universityboard.model.GroupDetails;
import com.example.universityboard.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/addgroup")
	public GroupDetails addGroup(@RequestBody GroupDetails groupDetails) {
		return this.adminServiceImpl.saveGroup(groupDetails);
	}
	
	@PutMapping("/updategroup")
	public GroupDetails updateGroup(@RequestBody GroupDetails groupDetails) {
		return this.adminServiceImpl.updateGroup(groupDetails);
	}
	
	@DeleteMapping("/deletegroup/{groupName}")
	public void deleteGroup(@PathVariable String groupName) {
		adminServiceImpl.deleteGroup(groupName);
	}
	
	@GetMapping("/getgroupbyname/{groupName}")
	public GroupDetails getGroupByName(@PathVariable String groupName) {
		return adminServiceImpl.getGroupByName(groupName);
	}
	
	@GetMapping("/getallgroups")
	public List<GroupDetails> getAllGroups() {
		return adminServiceImpl.getAllGroups();
	}
	
}
