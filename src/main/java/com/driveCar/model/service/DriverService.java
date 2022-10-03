package com.driveCar.model.service;

import com.driveCar.model.model.request.DriverInput;
import com.driveCar.model.model.response.DriverDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface DriverService {

    public DriverDto createDriver(DriverInput driverInput);
    public DriverDto updateDriver(DriverInput driverInput);
    public List<DriverDto> getAllDriver();
    public DriverDto getDriverById(UUID uuid);
    public Boolean deleteDriver(UUID uuid);

}
