package com.example.parking.infrastructure.adapter.primary;

import com.example.parking.domain.model.parking.SpotCoordinates;
import com.example.parking.domain.model.vehicle.Bus;
import com.example.parking.domain.model.vehicle.Car;
import com.example.parking.domain.model.vehicle.Motorcycle;
import com.example.parking.domain.model.vehicle.Vehicle;
import com.example.parking.domain.port.primary.ParkingLotService;
import com.example.parking.infrastructure.adapter.primary.dto.ParkVehicleRequest;
import com.example.parking.infrastructure.adapter.primary.dto.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ParkingLotRest {

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/parkVehicle")
    List<String> parkVehicle(@RequestBody ParkVehicleRequest parkVehicleRequest) {

        Vehicle vehicle = prepareVehicle(parkVehicleRequest.getVehicle());

        Optional<SpotCoordinates[]> parkingSpots =
            parkingLotService.parkVehicle(parkVehicleRequest.getParkingId(), vehicle);

        return getSpotList(parkingSpots);
    }

    private List<String> getSpotList(Optional<SpotCoordinates[]> parkingSpots) {

        if (parkingSpots.isPresent()) {
            return Arrays.stream(parkingSpots.get())
                         .map(spot -> spot.getRowNo() + "." + spot.getSpotNo())
                         .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    private com.example.parking.domain.model.vehicle.Vehicle prepareVehicle(VehicleDto vehicle) {
        switch(vehicle.getVehicleType()) {
        case BUS: return new Bus(vehicle.getLicencePlates());
        case MOTORCYCLE: return new Motorcycle(vehicle.getLicencePlates());
        case CAR: return new Car(vehicle.getLicencePlates());
        default: throw new UnsupportedOperationException();
        }
    }
}
