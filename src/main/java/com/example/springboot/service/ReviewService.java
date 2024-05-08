package com.example.springboot.service;

import com.example.springboot.dto.ReviewDto;
import com.example.springboot.entity.ReviewEntity;
import com.example.springboot.interfaces.IReviewService;
import com.example.springboot.mapper.ReviewMapper;
import com.example.springboot.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService implements IReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ResponseEntity<ReviewDto> saveReview(ReviewDto reviewDto) {
        ReviewEntity reviewEntity = this.reviewRepository.save(this.reviewMapper.fromDto(reviewDto));

        return ResponseEntity
                .ok()
                .body(this.reviewMapper.toDto(reviewEntity));
    }
}
