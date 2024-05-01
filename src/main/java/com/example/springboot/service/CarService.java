package com.example.springboot.service;

import com.example.springboot.dto.CarDto;
import com.example.springboot.dto.CarResponseDto;
import com.example.springboot.entity.CarEntity;
import com.example.springboot.interfaces.ICarService;
import com.example.springboot.mapper.CarMapper;
import com.example.springboot.repository.CarRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;


@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public ResponseEntity<CarResponseDto> saveCar(CarDto carDto) {
        CarEntity transformedCar = this.carMapper.fromDto(carDto);
        CarEntity savedCar = this.carRepository.save(transformedCar);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        CarResponseDto
                                .builder()
                                .timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                                .description("New car %s created!".formatted(carDto.getProducer()))
                                .status(HttpStatus.CREATED)
                                .body(this.carMapper.toDto(savedCar))
                                .build()
                );
    }
}