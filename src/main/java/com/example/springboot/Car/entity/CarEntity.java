package com.example.springboot.Car.entity;

import com.example.springboot.Car.utils.view.View;
import com.fasterxml.jackson.annotation.JsonView;
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

    @NotBlank(message = "Model field cannot be empty!")
    @Column(unique = true)
    private String model;

    @NotBlank(message = "Producer field cannot be empty!")
    @Column
    private String producer;

    @Min(value = 0, message = "Minimum power cannot be lower than 0!")
    @Column
    private Integer power;
}
