package com.example.springboot.Car.interfaces;

import com.example.springboot.Car.dto.CarResponseDto;
import com.example.springboot.Car.dto.CarsResponseDto;
import com.example.springboot.Car.entity.CarEntity;
import org.springframework.http.ResponseEntity;

public interface ICarService {
    ResponseEntity<CarsResponseDto> getCars();
    ResponseEntity<CarResponseDto> getCarById(Long id);
    ResponseEntity<CarResponseDto> createCar(CarEntity car);
    ResponseEntity<CarResponseDto> removeCarById(Long id);
    ResponseEntity<CarsResponseDto> getCarsByPower(Integer power);
    ResponseEntity<CarsResponseDto> getCarsByProducer(String producer);
    ResponseEntity<CarResponseDto> searchCar(CarEntity car);
}
