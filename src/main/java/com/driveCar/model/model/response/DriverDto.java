package com.driveCar.model.model.response;

import com.driveCar.model.Entity.Car;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class DriverDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Set<Car> cars;

}
