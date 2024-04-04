package com.example.springboot.Car.utils.mappers;

import com.example.springboot.Car.dto.CarDto;
import com.example.springboot.Car.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarDto toDto(CarEntity car) {
        return CarDto
                .builder()
                .id(car.getId())
                .model(car.getModel())
                .producer(car.getProducer())
                .power(car.getPower())
                .build();
    }

    public CarEntity fromDto(CarDto carDto) {
        CarEntity car = new CarEntity();
        car.setId(carDto.getId());
        car.setModel(carDto.getModel());
        car.setProducer(carDto.getProducer());

        return car;
    }
}
