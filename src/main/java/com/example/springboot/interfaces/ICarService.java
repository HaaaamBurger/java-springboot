package com.example.springboot.interfaces;

import com.example.springboot.dto.CarDto;
import com.example.springboot.dto.CarResponseDto;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICarService {
    ResponseEntity<CarDto> saveCar(CarDto carDto);
    ResponseEntity<List<CarDto>> getAllCars();
    ResponseEntity<CarDto> getCarById(ObjectId id);
    ResponseEntity<CarDto> updateCar(CarDto carDto);
    ResponseEntity<CarDto> deleteCar(ObjectId id);
}
