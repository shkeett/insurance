package com.driveCar.model.model.request;

import com.driveCar.model.Entity.Car;
import lombok.Data;

import java.util.Set;

@Data
public class DriverInput {

    private String firstName;
    private String lastName;
    private Integer age;
    private Set<Car> cars;
}
