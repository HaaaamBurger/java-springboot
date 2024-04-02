package com.example.springboot.Car.dto;

import com.example.springboot.Car.entity.CarEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarsResponseDto {
    private String message;
    private List<CarEntity> body;
}
