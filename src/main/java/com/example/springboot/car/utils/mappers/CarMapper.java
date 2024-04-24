package com.example.springboot.car.utils.mappers;

import com.example.springboot.car.dto.CarDto;
import com.example.springboot.car.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarDto toDto(CarEntity car) {
        return CarDto
                .builder()
                .carId(car.getCarId())
                .model(car.getModel())
                .producer(car.getProducer())
                .power(car.getPower())
                .image(car.getImage())
                .build();
    }

    public CarEntity fromDto(CarDto carDto) {
        CarEntity car = new CarEntity();
        car.setPower(carDto.getPower());
        car.setModel(carDto.getModel());
        car.setImage(carDto.getImage());
        car.setProducer(carDto.getProducer());

        return car;
    }
}
