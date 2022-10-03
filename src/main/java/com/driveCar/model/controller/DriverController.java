package com.driveCar.model.controller;


import com.driveCar.model.model.request.DriverInput;
import com.driveCar.model.model.response.DriverDto;
import com.driveCar.model.service.DriverService;
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
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/testdriver")
    public String pong() {
        return "driver";
    }


    @PostMapping("/drivers")
    public ResponseEntity<DriverDto> createDriver(@RequestBody DriverInput driverInput) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/drivers").toUriString());
        return ResponseEntity.created(uri).body(driverService.createDriver(driverInput));

    }

    @PutMapping("/drivers")
    public ResponseEntity<DriverDto> updateDriver(DriverInput driverInput) {
        return ResponseEntity.ok(driverService.updateDriver(driverInput));
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDto>> getAllDriver() {
        return ResponseEntity.ok(driverService.getAllDriver());
    }

    @GetMapping("/drivers/{uuid}")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(driverService.getDriverById(uuid));
    }

    @DeleteMapping("/drivers/{uuid}")
    public Boolean deleteDriver(@PathVariable UUID uuid) {
        return driverService.deleteDriver(uuid);
    }
}