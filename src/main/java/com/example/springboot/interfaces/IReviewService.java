package com.example.springboot.interfaces;

import com.example.springboot.dto.ReviewDto;
import org.springframework.http.ResponseEntity;

public interface IReviewService {
    ResponseEntity<ReviewDto> saveReview(ReviewDto reviewDto);
}
