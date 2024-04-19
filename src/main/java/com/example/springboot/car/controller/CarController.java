package com.example.springboot.car.controller;

import com.example.springboot.car.dto.CarDto;
import com.example.springboot.car.entity.CarEntity;
import com.example.springboot.car.service.CarService;
import com.example.springboot.car.utils.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
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
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto car, @RequestParam("image") MultipartFile image) {
        return this.carService.createCar(car, image);
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

    @PostMapping("/cars/upload")
    public void createCarsByFile(@RequestParam("file") MultipartFile file) {
        List<CarDto> carsFromJson = this.carService.getCarsFromJson(file);
    }

//    @PostMapping("/cars/upload/${id}")
//    public ResponseEntity<CarDto> uploadCarImageById(@RequestParam MultipartFile image, Long carId) {
//        return this.carService.uploadCarImageById(image, carId);
//    }

}
