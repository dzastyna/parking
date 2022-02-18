package com.example.parking.domain.port.primary;

import com.example.parking.domain.model.parking.ParkingLot;
import com.example.parking.domain.model.parking.SpotCoordinates;
import com.example.parking.domain.model.vehicle.Bus;
import com.example.parking.domain.model.vehicle.Car;
import com.example.parking.domain.model.vehicle.Motorcycle;
import com.example.parking.domain.model.vehicle.Vehicle;
import com.example.parking.domain.repository.InMemoryParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ParkingService {

    @Autowired
    private InMemoryParkingRepository parkingRepository;

    public Optional<SpotCoordinates[]> parkBus(String parkingId, String licencePlates) {
        Vehicle bus = new Bus(licencePlates);
        Optional<ParkingLot> parkingLot = parkingRepository.findById(parkingId);
        return parkingLot.get().tryParkingVehicle(bus);
    }

    public Optional<SpotCoordinates[]> parkCar(String parkingId, String licencePlates) {
        Vehicle car = new Car(licencePlates);
        Optional<ParkingLot> parkingLot = parkingRepository.findById(parkingId);
        return parkingLot.get().tryParkingVehicle(car);
    }

    public Optional<SpotCoordinates[]> parkMotorcycle(String parkingId, String licencePlates) {
        Vehicle motor = new Motorcycle(licencePlates);
        Optional<ParkingLot> parkingLot = parkingRepository.findById(parkingId);
        return parkingLot.get().tryParkingVehicle(motor);
    }
}
