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

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public ResponseEntity<CarDto> saveCar(CarDto carDto) {
        CarEntity transformedCar = this.carMapper.fromDto(carDto);
        CarEntity savedCar = this.carRepository.save(transformedCar);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.carMapper.toDto(savedCar));
    }

    @Override
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarEntity> cars = this.carRepository.findAll();
        return ResponseEntity
                .ok()
                .body(
                     cars.stream().map(this.carMapper::toDto).toList()
                );
    }

    @Override
    public ResponseEntity<CarDto> getCarById(ObjectId id) {
        return ResponseEntity
                .ok()
                .body(this.carMapper.toDto(this.carRepository.findById(id).orElseThrow()));
    }

    @Override
    public ResponseEntity<CarDto> deleteCar(ObjectId id) {
        CarEntity car = this.carRepository.findById(id).orElseThrow();
        this.carRepository.delete(car);
        return ResponseEntity.ok()
                .body(this.carMapper.toDto(car));
    }

    @Override
    public ResponseEntity<CarDto> updateCar(CarDto carDto) {
        return null;
    }

}