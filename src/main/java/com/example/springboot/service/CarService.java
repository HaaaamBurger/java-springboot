package com.example.springboot.service;

import com.example.springboot.dto.CarDto;
import com.example.springboot.dto.CarResponseDto;
import com.example.springboot.entity.CarEntity;
import com.example.springboot.interfaces.ICarService;
import com.example.springboot.mapper.CarMapper;
import com.example.springboot.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;


    @Override
    public ResponseEntity<CarResponseDto> saveCar(CarDto carDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CarResponseDto
                        .builder()
                        .createdAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ"))
                        .description("New car %s was created".formatted(carDto.getProducer()))
                        .status(HttpStatus.CREATED)
                        .build());
    }

//    @Override
    public ResponseEntity<List<CarDto>> getCars() {
        List<CarEntity> carEntities = carRepository.findAll();
        List<CarDto> carDtos = new ArrayList<>();

        for(CarEntity carEntity : carEntities) {
            carDtos.add(carMapper.toDto(carEntity));
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carDtos);
    }

    @Override
    public ResponseEntity<CarDto> getCarById(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<CarResponseDto> removeCarById(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<CarResponseDto> updateCarById(CarDto carDto, ObjectId id) {
        return null;
    }
}
