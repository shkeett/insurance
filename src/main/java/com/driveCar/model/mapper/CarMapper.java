package com.driveCar.model.mapper;

import com.driveCar.model.Entity.Car;
import com.driveCar.model.model.request.CarInput;
import com.driveCar.model.model.response.CarDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CarMapper {

    public Car inputToCar(CarInput carInput) {

        Car car = new Car();
        car.setId(UUID.randomUUID());
        car.setBrand(carInput.getBrand());
        car.setModel(carInput.getModel());
        car.setDrivers(carInput.getDrivers());
        return car;
    }

    public CarDto CarToDto(Car carSave) {
        CarDto carDto = new CarDto();
        carDto.setBrand(carSave.getBrand());
        carDto.setModel(carSave.getModel());
        carDto.setDrivers(carSave.getDrivers());
        return carDto;
    }
}
