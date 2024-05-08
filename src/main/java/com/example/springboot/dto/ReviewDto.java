package com.example.springboot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {
    private String title;
    private String comment;
}
