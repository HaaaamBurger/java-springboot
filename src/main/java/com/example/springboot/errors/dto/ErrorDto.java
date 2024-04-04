package com.example.springboot.errors.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorDto {
    private Date timestamp;
    private String message;
}
