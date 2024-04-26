package com.example.springboot.interfaces;

import com.example.springboot.dto.CarDto;
import com.example.springboot.dto.CarResponseDto;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

public interface ICarService {
    ResponseEntity<CarResponseDto> saveCar(CarDto carDto);
//    ResponseEntity<CarDto[]> getCars();
    ResponseEntity<CarDto> getCarById(ObjectId id);
    ResponseEntity<CarResponseDto> removeCarById(ObjectId id);
    ResponseEntity<CarResponseDto> updateCarById(CarDto carDto, ObjectId id);
}
