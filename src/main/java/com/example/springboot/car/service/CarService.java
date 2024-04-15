package com.example.springboot.car.service;

import com.example.springboot.car.dto.CarDto;
import com.example.springboot.car.entity.CarEntity;
import com.example.springboot.car.utils.interfaces.ICarService;
import com.example.springboot.car.repository.CarRepository;
import com.example.springboot.car.utils.mappers.CarMapper;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.springboot.serviceeiml.EmailServiceImpl;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final EmailServiceImpl emailServiceImpl;

    @Override
    public ResponseEntity<List<CarDto>> getCars() {
        List<CarEntity> cars = this.carRepository.findAll();
        return ResponseEntity.ok().body((cars.stream().map(carMapper::toDto).toList()));
    }

    @Override
    public ResponseEntity<CarDto> getCarById(Long id) {
        Optional<CarEntity> car = this.carRepository.findById(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(this.carMapper.toDto(car.get()));
    }

    @Override
    public ResponseEntity<CarDto> createCar(CarEntity car) {
        try {
            this.carRepository.save(car);
            this.emailServiceImpl.sendMailWithHTML("gemasclashes@gmail.com", "Hello World!!", "lorem ipsum");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.carMapper.toDto(car));
    }

    @Override
    public ResponseEntity<CarDto> removeCarById(Long id) {
        Optional<CarEntity> car = this.carRepository.findById(id);
        this.carRepository.delete(car.get());

        return ResponseEntity.ok().body(this.carMapper.toDto(car.get()));
    }

    @Override
    public ResponseEntity<List<CarDto>> getCarsByPower(Integer power) {
        return ResponseEntity.ok().body(this.carRepository
                .findAllByPower(power)
                .stream()
                .map(this.carMapper::toDto)
                .toList()
        );
    }

    @Override
    public ResponseEntity<List<CarDto>> getCarsByProducer(String producer) {
        return ResponseEntity.ok().body(this.carRepository
                .findAllByProducer(producer)
                .stream()
                .map(this.carMapper::toDto)
                .toList()
        );
    }
}
