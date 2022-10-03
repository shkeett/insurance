package com.driveCar.model.service;


import com.driveCar.model.model.request.CarInput;
import com.driveCar.model.model.response.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CarService {
    public CarDto createCar(CarInput carInput);
    public CarDto updateCar(CarInput carInput);
    public List<CarDto> getAllCar();
    public CarDto getCarById(UUID uuid);
    public Boolean deleteCar(UUID uuid);


}
