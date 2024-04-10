package com.example.springboot.Car.controller;

import com.example.springboot.Car.dto.CarDto;
import com.example.springboot.Car.entity.CarEntity;
import com.example.springboot.Car.service.CarService;
import com.example.springboot.Car.utils.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @JsonView(View.PrivateAccess.class)
    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getCars() {
        return this.carService.getCars();
    }

    @PostMapping("/cars")
    public ResponseEntity<CarDto> createCar(@RequestBody CarEntity car) {
        return this.carService.createCar(car);
    }

    @JsonView(View.PublicAccess.class)
    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        return this.carService.getCarById(id);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<CarDto> removeCarById(@PathVariable Long id) {
        return this.carService.removeCarById(id);
    }

    @JsonView(View.MediumAccess.class)
    @GetMapping("/cars/power/{power}")
    public ResponseEntity<List<CarDto>> getCarsByPower(@PathVariable Integer power) {
        return this.carService.getCarsByPower(power);
    }

    @JsonView(View.MediumAccess.class)
    @GetMapping("/cars/producer/{producer}")
    public ResponseEntity<List<CarDto>> getCarsByProducer(@PathVariable String producer) {
        return this.carService.getCarsByProducer(producer);
    }

}
