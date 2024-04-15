package com.example.springboot.errors;

import com.example.springboot.errors.dto.ErrorDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {
    private static final String NEW_LINE = "\n";

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorDto> validationErrorHandler(ConstraintViolationException exception) {
        String exceptionMessage = exception.getConstraintViolations()
                .stream()
                .filter(Objects::nonNull)
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(NEW_LINE));

        return ResponseEntity.badRequest().body(getErrorDto(exceptionMessage));
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<ErrorDto> uniqueEntityErrorHandler(SQLException exception) {
        return ResponseEntity
                .internalServerError()
                .body(getErrorDto(exception.getMessage()));
    }

    private ErrorDto getErrorDto(String message) {
        return ErrorDto.builder()
                .timestamp(new Date())
                .message(message)
                .build();
    }
}
