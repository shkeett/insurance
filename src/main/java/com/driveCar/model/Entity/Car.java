package com.driveCar.model.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(schema = "ins", name = "car")
public class Car {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;



    @ManyToMany(mappedBy = "cars")
    private Set<Driver> drivers;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, drivers);
    }
}