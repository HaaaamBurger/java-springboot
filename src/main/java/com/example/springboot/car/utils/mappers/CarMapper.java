package com.example.springboot.car.utils.mappers;

import com.example.springboot.car.dto.CarDto;
import com.example.springboot.car.entity.CarEntity;
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
