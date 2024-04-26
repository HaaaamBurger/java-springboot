package com.example.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Document("CARS")
public class CarEntity {
    @MongoId
    private ObjectId id;

    private String model;

    private String producer;

    private Integer power;
}
