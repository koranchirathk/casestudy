package com.example.universityboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.universityboard.model.User;
import com.example.universityboard.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/user")
	public User addUser(@RequestBody User user) throws Exception {
		return this.userServiceImpl.saveUser(user);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/getalluser")
	public List<User> getAllUsers() {
		return this.userServiceImpl.getAll();
	}

	@GetMapping("/getuserdetail")
	public User getUserDetails(@RequestHeader("username") String username) {
		return this.userServiceImpl.getUserDetails(username);
	}

}
