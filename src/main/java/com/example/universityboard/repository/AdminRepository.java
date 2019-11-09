package com.example.universityboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.universityboard.model.GroupDetails;

public interface AdminRepository extends MongoRepository<GroupDetails, String> {

	GroupDetails findByGroupName(String groupName);
}