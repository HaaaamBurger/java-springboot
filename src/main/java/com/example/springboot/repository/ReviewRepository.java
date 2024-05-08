package com.example.springboot.repository;

import com.example.springboot.entity.ReviewEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<ReviewEntity, ObjectId> {
}
