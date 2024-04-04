package com.example.springboot.Car.utils.interfaces;

import com.example.springboot.Car.dto.CarDto;
import com.example.springboot.Car.entity.CarEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICarService {
    ResponseEntity<List<CarDto>> getCars();
    ResponseEntity<CarDto> getCarById(Long id);
    ResponseEntity<CarDto> createCar(CarEntity car);
    ResponseEntity<CarDto> removeCarById(Long id);
    ResponseEntity<List<CarDto>> getCarsByPower(Integer power);
    ResponseEntity<List<CarDto>> getCarsByProducer(String producer);
}
