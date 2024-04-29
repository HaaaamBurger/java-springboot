package com.example.springboot.service;

import com.example.springboot.dto.CarDto;
import com.example.springboot.dto.CarResponseDto;
import com.example.springboot.entity.CarEntity;
import com.example.springboot.mapper.CarMapper;
import com.example.springboot.repository.CarRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public ResponseEntity<CarEntity> saveCar(CarDto carDto) {
        CarEntity carEntity = this.carRepository.save(this.carMapper.fromDto(carDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(carEntity);
    }
}