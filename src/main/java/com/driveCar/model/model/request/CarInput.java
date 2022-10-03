package com.driveCar.model.model.request;

import com.driveCar.model.Entity.Driver;
import lombok.Data;

import java.util.Set;

@Data
public class CarInput {

    private String brand;
    private String model;
    private Set<Driver> drivers;
}
