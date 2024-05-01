package com.example.springboot.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Builder
public class CarResponseDto {
    private Date timestamp;
    private String description;
    private HttpStatus status;
    private CarDto body;
}
