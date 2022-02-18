package com.example.parking.infrastructure.adapter.primary;

import com.example.parking.domain.model.parking.SpotCoordinates;
import com.example.parking.domain.port.primary.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ParkingAdapter {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("/parkVehicle")
    String parkVehicle(@RequestBody ParkingRequest parkingRequest) {
        Optional<SpotCoordinates[]> parkingSpots = Optional.empty();

        switch(parkingRequest.getVehicle().getVehicleType()) {
        case BUS: parkingSpots = parkBus(parkingRequest); break;
        case MOTORCYCLE: parkingSpots = parkMotorcycle(parkingRequest); break;
        case CAR: parkingSpots = parkCar(parkingRequest); break;
        default: throw new UnsupportedOperationException();
        }

        return getFirstSpotCoordinates(parkingSpots);
    }

    private String getFirstSpotCoordinates(Optional<SpotCoordinates[]> parkingSpots) {
        if (parkingSpots.isPresent()) {
            SpotCoordinates firstSpotCoordinates = parkingSpots.get()[0];
            return firstSpotCoordinates.getRowNo() + "." + firstSpotCoordinates.getSpotNo();
        } else {
            return null;
        }
    }

    private Optional<SpotCoordinates[]> parkCar(ParkingRequest parkingRequest) {
        return parkingService.parkCar(
            parkingRequest.getParkingId(),
            parkingRequest.getVehicle().getLicencePlates()
        );
    }

    private Optional<SpotCoordinates[]> parkMotorcycle(ParkingRequest parkingRequest) {
        return parkingService.parkMotorcycle(
            parkingRequest.getParkingId(),
            parkingRequest.getVehicle().getLicencePlates()
        );
    }

    private Optional<SpotCoordinates[]> parkBus(@RequestBody ParkingRequest parkingRequest) {
        return parkingService.parkBus(
            parkingRequest.getParkingId(),
            parkingRequest.getVehicle().getLicencePlates()
        );
    }
}
