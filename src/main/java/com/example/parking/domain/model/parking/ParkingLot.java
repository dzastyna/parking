package com.example.parking.domain.model.parking;

import com.example.parking.domain.model.vehicle.Vehicle;

import java.util.Optional;

public class ParkingLot {

    private Row[] rows;

    public ParkingLot(Row[] rows) {
        this.rows = rows;
    }

    public Optional<SpotCoordinates[]> tryParkingVehicle(Vehicle vehicle) {
        for(Row level : rows) {
            Optional<SpotCoordinates[]> spotCoordinates = level.tryParkingVehicle(vehicle);
            if (spotCoordinates.isPresent()) {
                return spotCoordinates;
            }
        }
        return Optional.empty();
    }
}
