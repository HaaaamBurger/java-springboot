package com.example.springboot.dto;

import com.example.springboot.entity.CarEntity;
import lombok.Builder;

@Builder
public class CarResponseDto {
    private String description;
    private CarEntity response;
}
