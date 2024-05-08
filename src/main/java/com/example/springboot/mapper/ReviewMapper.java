package com.example.springboot.mapper;

import com.example.springboot.dto.ReviewDto;
import com.example.springboot.entity.ReviewEntity;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewDto toDto(ReviewEntity reviewEntity) {
        return ReviewDto
                .builder()
                .comment(reviewEntity.getComment())
                .title(reviewEntity.getTitle())
                .build();
    }

    public ReviewEntity fromDto(ReviewDto reviewDto) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setComment(reviewDto.getComment());
        reviewEntity.setTitle(reviewDto.getTitle());

        return reviewEntity;
    }
}
