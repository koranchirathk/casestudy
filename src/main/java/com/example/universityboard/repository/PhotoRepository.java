package com.example.universityboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.universityboard.model.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}

