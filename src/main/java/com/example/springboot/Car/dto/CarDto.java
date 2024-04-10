package com.example.springboot.Car.dto;

import com.example.springboot.Car.utils.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

@Data
@Builder
public class CarDto {
    @JsonView(View.PublicAccess.class)
    private Long id;

    @JsonView({View.PublicAccess.class, View.MediumAccess.class, View.PrivateAccess.class})
    private String model;

    @JsonView({View.PublicAccess.class, View.MediumAccess.class, View.PrivateAccess.class})
    private String producer;

    @JsonView({View.PublicAccess.class, View.MediumAccess.class})
    private Integer power;
}
