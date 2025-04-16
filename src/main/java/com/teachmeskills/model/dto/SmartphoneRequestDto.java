package com.teachmeskills.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

public class SmartphoneRequestDto {
    @Size(min = 2, max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 2, max = 255)
    @NotNull
    @Column(name = "screen", nullable = false)
    private String screen;

    @Size(max = 255)
    @NotNull
    @Column(name = "cpu", nullable = false)
    private String cpu;

    @NotNull
    @ColumnDefault("false")
    @Column(name = "e_sim_support", nullable = false)
    private Boolean eSimSupport = false;

    @NotNull
    @Column(name = "camera_resolution", nullable = false)
    private Long cameraResolution;

    @Column(name = "discount")
    private Long discount;

    @Size(max = 255)
    @Column(name = "image")
    private String image;
}
