package com.example.springboot.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

@Builder
public class CarResponseDto {
    private SimpleDateFormat createdAt;
    private String description;
    private HttpStatus status;
}
