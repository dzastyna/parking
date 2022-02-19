package com.example.parking.domain.model.vehicle;

public abstract class Vehicle {
    private String licencePlate;

    public Vehicle(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + licencePlate + "}";
    }
}
