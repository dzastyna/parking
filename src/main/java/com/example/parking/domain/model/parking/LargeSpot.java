package com.example.parking.domain.model.parking;

import com.example.parking.domain.model.vehicle.Bus;
import com.example.parking.domain.model.vehicle.Car;
import com.example.parking.domain.model.vehicle.Vehicle;

public class LargeSpot extends Spot {

    public LargeSpot(int number) {
        super(number);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return super.canFitVehicle(vehicle) || isCar(vehicle) || isBus(vehicle);
    }

    private boolean isCar(Vehicle vehicle) {
        return vehicle instanceof Car;
    }

    private boolean isBus(Vehicle vehicle) {
        return vehicle instanceof Bus;
    }
}
