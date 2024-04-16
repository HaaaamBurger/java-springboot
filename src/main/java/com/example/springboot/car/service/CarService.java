package com.example.springboot.car.service;

import com.example.springboot.car.dto.CarDto;
import com.example.springboot.car.entity.CarEntity;
import com.example.springboot.car.utils.interfaces.ICarService;
import com.example.springboot.car.repository.CarRepository;
import com.example.springboot.car.utils.mappers.CarMapper;
import com.example.springboot.services.EmailService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final EmailService emailService;
    private final ObjectMapper objectMapper;

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
    public ResponseEntity<CarDto> createCar(CarDto car) {

        CarEntity mappedCar = carMapper.fromDto(car);
        byte[] file = null;
        try {
            file = car.getImage().getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mappedCar.setImage(file);

        this.carRepository.save(mappedCar);
        this.emailService.sendMail("gemasclashes@gmail.com", "CarAPI", "Created new car " + car.getProducer() + ", " + car.getModel());

        return ResponseEntity.status(HttpStatus.CREATED).body(this.carMapper.toDto(mappedCar));
    }

    @Override
    public ResponseEntity<CarDto> removeCarById(Long id) {
        Optional<CarEntity> car = this.carRepository.findById(id);
        this.carRepository.delete(car.get());
        this.emailService.sendMail("gemasclashes@gmail.com", "CarAPI", "Removed car " + car.get().getProducer() + ", " + car.get().getModel());

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

    public List<CarDto> getCarsFromJson(MultipartFile file) {
        try {
            return this.objectMapper.readValue(file.getBytes(), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
