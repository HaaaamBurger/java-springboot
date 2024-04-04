package com.example.springboot.errors;

import com.example.springboot.errors.dto.ErrorDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorDto> validationErrorHandler(ConstraintViolationException exception) {
        String exceptionMessage = Objects
                .requireNonNull(exception.getConstraintViolations()
                        .stream()
                        .findFirst()
                        .orElse(null))
                        .getMessage();

        return ResponseEntity.badRequest().body(ErrorDto
                .builder()
                .timestamp(new Date())
                .message(exceptionMessage)
                .build());
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<ErrorDto> uniqueEntityErrorHandler(SQLException exception) {
        String exceptionMessage = exception.getMessage();

        return ResponseEntity
                .badRequest()
                .body(ErrorDto
                        .builder()
                        .timestamp(new Date())
                        .message(exceptionMessage)
                        .build()
                );
    }
}
