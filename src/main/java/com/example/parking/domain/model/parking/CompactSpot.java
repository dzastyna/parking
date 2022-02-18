package com.example.parking.domain.model.parking;

import com.example.parking.domain.model.vehicle.Car;
import com.example.parking.domain.model.vehicle.Vehicle;

public class CompactSpot extends Spot {
    public CompactSpot(int number) {
        super(number);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return super.canFitVehicle(vehicle) || isCar(vehicle);
    }

    private boolean isCar(Vehicle vehicle) {
        return vehicle instanceof Car;
    }
}
