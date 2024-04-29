package com.example.springboot.interfaces;

import com.example.springboot.dto.CarDto;
import com.example.springboot.dto.CarResponseDto;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

public interface ICarService {
    ResponseEntity<CarResponseDto> saveCar(CarDto carDto);
}
