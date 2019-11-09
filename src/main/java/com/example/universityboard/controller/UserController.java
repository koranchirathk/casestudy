package com.example.universityboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.universityboard.model.User;
import com.example.universityboard.repository.UserRepository;

@RestController
@RequestMapping("/restapi/v1")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/getusers")
	public List<User> getusers() {
		return userRepository.findAll();
	}

}
