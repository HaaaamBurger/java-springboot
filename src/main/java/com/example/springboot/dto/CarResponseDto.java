package com.example.springboot.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;

@Builder
public class CarResponseDto {
    private SimpleDateFormat timestamp;
    private String description;
    private HttpStatus status;
    private CarDto body;
}
