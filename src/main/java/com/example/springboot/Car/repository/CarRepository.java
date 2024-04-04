package com.example.springboot.Car.repository;

import com.example.springboot.Car.dto.CarDto;
import com.example.springboot.Car.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    List<CarEntity> findAllByPower(Integer power);
    List<CarEntity> findAllByProducer(String producer);
}
