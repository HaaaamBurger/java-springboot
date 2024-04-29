package com.example.springboot.repository;

import com.example.springboot.entity.CarEntity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<CarEntity, ObjectId> { }
