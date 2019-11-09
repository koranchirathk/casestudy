package com.example.universityboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.universityboard.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

}