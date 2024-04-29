package com.example.springboot.service;

import com.example.springboot.dto.CarDto;
import com.example.springboot.dto.CarResponseDto;
import com.example.springboot.entity.CarEntity;
import com.example.springboot.interfaces.ICarService;
import com.example.springboot.mapper.CarMapper;
import com.example.springboot.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public ResponseEntity<CarEntity> saveCar(CarDto carDto) {
        this.carRepository.save(this.carMapper.fromDto(carDto));
        return ResponseEntity.ok().body(this.carMapper.fromDto(carDto));
    }
}