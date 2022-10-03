package com.driveCar.model.model.response;

import com.driveCar.model.Entity.Driver;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class CarDto {

    private UUID id;
    private String brand;
    private String model;
    private Set<Driver> drivers;
}
