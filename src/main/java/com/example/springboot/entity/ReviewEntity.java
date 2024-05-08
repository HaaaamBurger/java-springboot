package com.example.springboot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("REVIEWS")
public class ReviewEntity {
    @MongoId
    private String id;

    private String title;

    private String comment;
}
