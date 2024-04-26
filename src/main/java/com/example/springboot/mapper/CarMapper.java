package com.example.springboot.mapper;

import com.example.springboot.dto.CarDto;
import com.example.springboot.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarDto toDto(CarEntity carEntity) {
        return CarDto
                .builder()
                .id(carEntity.getId())
                .model(carEntity.getModel())
                .power(carEntity.getPower())
                .producer(carEntity.getProducer())
                .build();
    }

    public CarEntity fromDto(CarDto carDto) {
        CarEntity carEntity = new CarEntity();

        carEntity.setId(carDto.getId());
        carEntity.setModel(carDto.getModel());
        carEntity.setPower(carDto.getPower());
        carEntity.setProducer(carDto.getProducer());

        return carEntity;
    }
}
