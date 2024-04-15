package com.example.springboot.car.repository;

import com.example.springboot.car.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    List<CarEntity> findAllByPower(Integer power);
    List<CarEntity> findAllByProducer(String producer);
}
