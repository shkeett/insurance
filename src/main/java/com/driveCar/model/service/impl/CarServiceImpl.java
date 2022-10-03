package com.driveCar.model.service.impl;

import com.driveCar.model.Entity.Car;
import com.driveCar.model.exception.NoSuchCarException;
import com.driveCar.model.mapper.CarMapper;
import com.driveCar.model.model.request.CarInput;
import com.driveCar.model.model.response.CarDto;
import com.driveCar.model.repository.CarRepository;
import com.driveCar.model.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto createCar(CarInput carInput) {
        Car car = carMapper.inputToCar(carInput);
        Car saveCar = carRepository.save(car);
        return carMapper.CarToDto(saveCar);
    }

    @Override
    public CarDto updateCar(CarInput carInput) {
        Car car = carMapper.inputToCar(carInput);
        Car updateCar = carRepository.save(car);
        return carMapper.CarToDto(updateCar);

    }

    @Override
    public List<CarDto> getAllCar() {
        List<Car> list = carRepository.findAll();
        List<CarDto> listDto = null;
        for (Car car : list) {
            CarDto carDto = carMapper.CarToDto(car);
            listDto.add(carDto);
        }
        return listDto;
    }

    @Override
    public CarDto getCarById(UUID uuid) {
        Car carSave = carRepository.getReferenceById(uuid);
        return carMapper.CarToDto(carSave);
    }


    @Override
    public Boolean deleteCar(UUID uuid) {
        Car car = carRepository.getReferenceById(uuid);
        if (car == null) {
            throw new NoSuchCarException("There is no Car");
        }
        carRepository.deleteById(uuid);
        return true;
    }
}
