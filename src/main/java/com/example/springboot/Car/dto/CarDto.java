package com.example.springboot.Car.dto;

import com.example.springboot.Car.utils.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

@Data
@Builder
public class CarDto {
    @JsonView(View.External.class)
    private Long id;

    @JsonView(View.Internal.class)
    private String model;

    @JsonView(View.Internal.class)
    private String producer;

    @JsonView(View.Internal.class)
    private Integer power;
}
