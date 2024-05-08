package com.example.springboot.controller;

import com.example.springboot.dto.CarDto;
import com.example.springboot.dto.CarResponseDto;
import com.example.springboot.service.CarService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController  {
    private final CarService carService;

    @PostMapping("/cars")
    public ResponseEntity<CarDto> saveCar(@RequestBody CarDto carDto) {
        return this.carService.saveCar(carDto);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return this.carService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable ObjectId id) {
        return this.carService.getCarById(id);
    }
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<CarDto> deleteCar(@PathVariable ObjectId id) {
        return this.carService.deleteCar(id);
    }
    @PutMapping("/cars/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable ObjectId id, @RequestBody CarDto carDto) {
        return this.carService.updateCar(carDto, id);
    }

}
