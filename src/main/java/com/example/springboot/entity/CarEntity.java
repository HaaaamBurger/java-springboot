package com.example.springboot.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("CARS")
public class CarEntity {
    @MongoId
    private String id;

    private String model;

    private String producer;

    private Integer power;
}
