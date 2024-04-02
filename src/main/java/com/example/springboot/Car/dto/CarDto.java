package com.example.springboot.Car.dto;

import lombok.*;

@Data
@Builder
public class CarDto {
    private Long id;

    private String model;

    private String producer;

    private Integer power;
}
