package com.example.springboot.controller;

import com.example.springboot.dto.CarDto;
import com.example.springboot.dto.CarResponseDto;
import com.example.springboot.entity.CarEntity;
import com.example.springboot.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController  {
    private final CarService carService;

    @PostMapping("/cars")
    public ResponseEntity<CarEntity> saveCar(@RequestBody CarDto carDto) {
        return this.carService.saveCar(carDto);
    }

}
