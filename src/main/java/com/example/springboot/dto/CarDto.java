package com.example.springboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;

@Getter
@Builder
@ToString
public class CarDto {
    private ObjectId id;

    private String model;

    private String producer;

    private Integer power;
}
