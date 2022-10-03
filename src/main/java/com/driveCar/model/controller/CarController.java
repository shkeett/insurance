package com.driveCar.model.controller;

import com.driveCar.model.model.request.CarInput;
import com.driveCar.model.model.response.CarDto;
import com.driveCar.model.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/testcar")
    public String car() {
        return "car";
    }


    @PostMapping("/cars")
    public ResponseEntity<CarDto> createCar(@RequestBody CarInput carInput) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/cars").toUriString());
        return ResponseEntity.created(uri).body(carService.createCar(carInput));
    }

    @PutMapping("/cars")
    public ResponseEntity<CarDto> updateCar(CarInput carInput) {
        return ResponseEntity.ok(carService.updateCar(carInput));
    }

    @GetMapping("/cars")
    public List<CarDto> getAllCar() {
        return carService.getAllCar();
    }

    @GetMapping("/cars/{uuid}")
    public ResponseEntity<CarDto> getCarById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(carService.getCarById(uuid));
    }

    @DeleteMapping("/cars/{uuid}")
    public Boolean deleteCar(@PathVariable UUID uuid) {
        return carService.deleteCar(uuid);
    }
}