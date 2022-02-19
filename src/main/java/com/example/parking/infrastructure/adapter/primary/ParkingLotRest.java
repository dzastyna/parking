package com.example.parking.infrastructure.adapter.primary;

import com.example.parking.domain.model.parking.SpotCoordinates;
import com.example.parking.domain.port.primary.ParkingService;
import com.example.parking.infrastructure.adapter.secondary.ParkingJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ParkingLotRest {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private ParkingJpaRepository parkingJpaRepository;

    @PostMapping("/parkVehicle")
    String parkVehicle(@RequestBody ParkVehicleRequest parkVehicleRequest) {
        Optional<SpotCoordinates[]> parkingSpots = Optional.empty();

        switch(parkVehicleRequest
            .getVehicle().getVehicleType()) {
        case BUS: parkingSpots = parkBus(parkVehicleRequest); break;
        case MOTORCYCLE: parkingSpots = parkMotorcycle(parkVehicleRequest); break;
        case CAR: parkingSpots = parkCar(parkVehicleRequest); break;
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

    private Optional<SpotCoordinates[]> parkCar(ParkVehicleRequest parkVehicleRequest) {
        return parkingService.parkCar(
            parkVehicleRequest.getParkingId(),
            parkVehicleRequest
                .getVehicle().getLicencePlates()
        );
    }

    private Optional<SpotCoordinates[]> parkMotorcycle(ParkVehicleRequest parkVehicleRequest) {
        return parkingService.parkMotorcycle(
            parkVehicleRequest.getParkingId(),
            parkVehicleRequest
                .getVehicle().getLicencePlates()
        );
    }

    private Optional<SpotCoordinates[]> parkBus(@RequestBody ParkVehicleRequest parkVehicleRequest) {
        return parkingService.parkBus(
            parkVehicleRequest.getParkingId(),
            parkVehicleRequest
                .getVehicle().getLicencePlates()
        );
    }
}
