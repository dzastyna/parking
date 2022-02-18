package com.example.parking.domain.model.vehicle;

public abstract class Vehicle {
    private String licencePlate;

    public Vehicle(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public boolean equals(Vehicle other) {
        return this.licencePlate.equals(other.licencePlate);
    }
}
