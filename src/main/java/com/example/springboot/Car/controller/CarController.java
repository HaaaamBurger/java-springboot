package com.example.springboot.Car.controller;

import com.example.springboot.Car.dto.CarResponseDto;
import com.example.springboot.Car.dto.CarsResponseDto;
import com.example.springboot.Car.entity.CarEntity;
import com.example.springboot.Car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<CarsResponseDto> getCars() {
        return this.carService.getCars();
    }

    @PostMapping("/cars")
    public ResponseEntity<CarResponseDto> createCar(@RequestBody CarEntity car) {
        return this.carService.createCar(car);
    }

}
