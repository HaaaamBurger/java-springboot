package com.example.springboot.Car.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "CARS")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String model;

    private String producer;

    @Min(value = 0, message = "Minimum power cannot be lower than 0!")
    private Integer power;
}
