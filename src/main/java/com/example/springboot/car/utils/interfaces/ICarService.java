package com.example.springboot.car.utils.interfaces;

import com.example.springboot.car.dto.CarDto;
import com.example.springboot.car.entity.CarEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICarService {
    ResponseEntity<List<CarDto>> getCars();
    ResponseEntity<CarDto> getCarById(Long id);
    ResponseEntity<CarDto> createCar(CarDto car, MultipartFile image);
    ResponseEntity<CarDto> removeCarById(Long id);
    ResponseEntity<List<CarDto>> getCarsByPower(Integer power);
    ResponseEntity<List<CarDto>> getCarsByProducer(String producer);
}
