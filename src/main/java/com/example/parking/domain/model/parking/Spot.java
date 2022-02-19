package com.example.parking.domain.model.parking;

import com.example.parking.domain.model.parking.status.SpotStatus;
import com.example.parking.domain.model.vehicle.Motorcycle;
import com.example.parking.domain.model.vehicle.Vehicle;

public abstract class Spot {

    private Vehicle vehicle;

    private int number;

    public Spot(int number) {
        this.number =  number;
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

    SpotStatus getStatus() {
        return new SpotStatus(getType(), getNumber(), getVehicleStatus());
    }

    int getNumber() {
        return number;
    }

    private String getType() {
        return this.getClass().getSimpleName();
    }

    private String getVehicleStatus() {
        return this.vehicle == null ? "<->" : "<" + this.vehicle.toString() + ">";
    }
}
