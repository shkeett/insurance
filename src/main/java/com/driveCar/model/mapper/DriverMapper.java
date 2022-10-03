package com.driveCar.model.mapper;

import com.driveCar.model.Entity.Driver;
import com.driveCar.model.model.request.DriverInput;
import com.driveCar.model.model.response.DriverDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DriverMapper {

    public Driver inputToDriver(DriverInput driverInput) {

        Driver driver = new Driver();
        driver.setId(UUID.randomUUID());
        driver.setFirstName(driverInput.getFirstName());
        driver.setLastName(driverInput.getLastName());
        driver.setAge(driverInput.getAge());
        driver.setCars(driverInput.getCars());
        return driver;
    }

    public DriverDto DriverToDto(Driver driverSave) {
        DriverDto driverDto = new DriverDto();
        driverDto.setFirstName(driverSave.getFirstName());
        driverDto.setLastName(driverSave.getLastName());
        driverDto.setAge(driverSave.getAge());
        driverDto.setCars(driverSave.getCars());

        return driverDto;
    }
}
