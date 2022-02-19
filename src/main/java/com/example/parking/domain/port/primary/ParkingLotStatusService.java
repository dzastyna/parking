package com.example.parking.domain.port.primary;

import com.example.parking.domain.model.parking.status.ParkingStatus;
import com.example.parking.infrastructure.adapter.secondary.ParkingInMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingLotStatusService {

    @Autowired
    private ParkingInMemoryRepository parkingRepository;

    public List<? extends ParkingStatus> get() {
        return parkingRepository
            .findAll()
            .values()
            .stream()
            .map(parkingLot -> parkingLot.getStatus())
            .collect(Collectors.toList());
    }
}
