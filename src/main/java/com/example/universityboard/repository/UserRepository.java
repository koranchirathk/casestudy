package com.example.universityboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.universityboard.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
