package com.example.springboot.Car.service;

import com.example.springboot.Car.dto.CarResponseDto;
import com.example.springboot.Car.dto.CarsResponseDto;
import com.example.springboot.Car.entity.CarEntity;
import com.example.springboot.Car.interfaces.ICarService;
import com.example.springboot.Car.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    private final CarRepository carRepository;

    @Override
    public ResponseEntity<CarsResponseDto> getCars() {
        List<CarEntity> cars = this.carRepository.findAll();

        String message = "Here I found for you " + (!cars.isEmpty() ? cars.size() > 1 ? cars.size() + " cars" : cars.size() + " car" : "0 cars");

            return ResponseEntity.ok().body(CarsResponseDto
                .builder()
                .message(message)
                .body(cars)
                .build());
    }

    @Override
    public ResponseEntity<CarResponseDto> getCarById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CarResponseDto> createCar(CarEntity car) {
        this.carRepository.save(car);

        return ResponseEntity.status(HttpStatus.CREATED).body(CarResponseDto
                .builder()
                .message("I successfully created car for you :)")
                .body(car)
                .build()
        );
    }

    @Override
    public ResponseEntity<CarResponseDto> removeCarById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CarsResponseDto> getCarsByPower(Integer power) {
        return null;
    }

    @Override
    public ResponseEntity<CarsResponseDto> getCarsByProducer(String producer) {
        return null;
    }

    @Override
    public ResponseEntity<CarResponseDto> searchCar(CarEntity car) {
        return null;
    }
}
