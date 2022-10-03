package com.driveCar.model.service.impl;

import com.driveCar.model.Entity.Driver;
import com.driveCar.model.exception.NoSuchDriverException;
import com.driveCar.model.mapper.DriverMapper;
import com.driveCar.model.model.request.DriverInput;
import com.driveCar.model.model.response.DriverDto;
import com.driveCar.model.repository.DriverRepository;
import com.driveCar.model.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    
    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Override
    public DriverDto createDriver(DriverInput driverInput) {
        Driver driver = driverMapper.inputToDriver(driverInput);
        Driver saveDriver = driverRepository.save(driver);
        return driverMapper.DriverToDto(saveDriver);
    }

    @Override
    public DriverDto updateDriver(DriverInput driverInput) {
        Driver driver = driverMapper.inputToDriver(driverInput);
        Driver updateDriver = driverRepository.save(driver);
        return  driverMapper.DriverToDto(updateDriver);

    }

    @Override
    public List<DriverDto> getAllDriver() {
        List<Driver> list = driverRepository.findAll();
        List<DriverDto> listDto = null;
        for (Driver driver : list ) {
            DriverDto driverDto = driverMapper.DriverToDto(driver);
            listDto.add(driverDto);
        }
        return listDto;
    }

    @Override
    public DriverDto getDriverById(UUID uuid) {
        Driver driverSave = driverRepository.getReferenceById(uuid);
        return  driverMapper.DriverToDto(driverSave);
    }

    @Override
    public Boolean deleteDriver(UUID uuid) {
        Driver driver = driverRepository.getReferenceById(uuid);
        if(driver==null){
            throw  new NoSuchDriverException("There is no Driver");
        }
        driverRepository.deleteById(uuid);
        return true;
    }
}
