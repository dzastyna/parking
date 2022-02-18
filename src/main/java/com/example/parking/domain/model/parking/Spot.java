package com.example.parking.domain.model.parking;

import com.example.parking.domain.model.vehicle.Motorcycle;
import com.example.parking.domain.model.vehicle.Vehicle;

public abstract class Spot {

    //TODO - remove comment - should I have Optional here?
    private Vehicle vehicle;

    private int number;

    public Spot(int number) {
        this.number =  number;
    }

    public int getNumber() {
        return number;
    }

    public boolean areConsecutiveSpots(Spot otherSpot) {
        return this.number == otherSpot.number - 1 || this.number == otherSpot.number + 1;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Motorcycle;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void release() {
        vehicle = null;
    }
}
