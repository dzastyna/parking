package com.example.parking.domain.port.primary;

import com.example.parking.domain.model.parking.ParkingLot;
import com.example.parking.domain.model.parking.SpotCoordinates;
import com.example.parking.domain.model.vehicle.Bus;
import com.example.parking.domain.model.vehicle.Car;
import com.example.parking.domain.model.vehicle.Motorcycle;
import com.example.parking.domain.model.vehicle.Vehicle;
import com.example.parking.infrastructure.adapter.secondary.ParkingInMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ParkingLotService {

    @Autowired
    private ParkingInMemoryRepository parkingRepository;

    public Optional<SpotCoordinates[]> parkVehicle(String parkingId, Vehicle vehicle) {
        Optional<ParkingLot> parkingLot = parkingRepository.findById(parkingId);
        return parkingLot.get().tryParkingVehicle(vehicle);
    }

}
