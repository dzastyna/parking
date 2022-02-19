package com.example.parking.infrastructure.adapter.primary;

import com.example.parking.domain.model.parking.status.ParkingStatus;
import com.example.parking.domain.port.primary.ParkingLotStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingLotStatusRest {

    @Autowired
    private ParkingLotStatusService service;

    @GetMapping("/show")
    public List<? extends ParkingStatus> showAll() {
        return service.get();
    }
}
