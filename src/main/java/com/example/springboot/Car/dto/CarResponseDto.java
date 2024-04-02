package com.example.springboot.Car.dto;

import com.example.springboot.Car.entity.CarEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarResponseDto {
    private String message;
    private CarEntity body;
}
