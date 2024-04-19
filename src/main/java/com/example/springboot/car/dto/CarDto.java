package com.example.springboot.car.dto;

import com.example.springboot.car.utils.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class CarDto {
    @JsonView(View.PublicAccess.class)
    private Long carId;

    @JsonView({View.PublicAccess.class, View.MediumAccess.class, View.PrivateAccess.class})
    private String model;

    @JsonView({View.PublicAccess.class, View.MediumAccess.class, View.PrivateAccess.class})
    private String producer;

    @JsonView({View.PublicAccess.class, View.MediumAccess.class})
    private Integer power;

    @JsonView({View.PublicAccess.class, View.MediumAccess.class})
    private byte[] image;
}
