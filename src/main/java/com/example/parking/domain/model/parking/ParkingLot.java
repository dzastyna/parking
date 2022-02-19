package com.example.parking.domain.model.parking;

import com.example.parking.domain.model.parking.status.ParkingStatus;
import com.example.parking.domain.model.parking.status.RowStatus;
import com.example.parking.domain.model.vehicle.Vehicle;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingLot {

    private Row[] rows;

    public ParkingLot(Row[] rows) {
        this.rows = rows;
    }

    public Optional<SpotCoordinates[]> tryParkingVehicle(Vehicle vehicle) {
        for(Row row : rows) {
            Optional<SpotCoordinates[]> spotCoordinates = row.tryParkingVehicle(vehicle);
            if (spotCoordinates.isPresent()) {
                return spotCoordinates;
            }
        }
        return Optional.empty();
    }

    public ParkingStatus getStatus() {
        return new ParkingStatus("?", prepareRowStatus());
    }

    private RowStatus[] prepareRowStatus() {
        return Arrays.stream(rows)
                     .map(r -> r.getStatus())
                     .collect(Collectors.toList())
                     .toArray(new RowStatus[rows.length]);
    }
}
