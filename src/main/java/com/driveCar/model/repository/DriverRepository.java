package com.driveCar.model.repository;

import com.driveCar.model.Entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository <Driver, UUID> {

}