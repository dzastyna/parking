package com.example.parking.infrastructure.adapter.primary;

import com.example.parking.domain.model.parking.status.ParkingStatus;
import com.example.parking.domain.model.parking.status.RowStatus;
import com.example.parking.domain.port.primary.ParkingLotStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ParkingLotStatusRest {

    @Autowired
    private ParkingLotStatusService service;

    @GetMapping("/show")
    public List<List<String>> showAll() {
        return service.get().stream().map(this::parkingToString).collect(Collectors.toList());
    }

    private List<String> parkingToString(ParkingStatus parkingStatus) {
        return Arrays.stream(parkingStatus.getRows()).map(this::rowToString).collect(Collectors.toList());
    }

    private String rowToString(RowStatus rowStatus) {
        StringBuilder sb = new StringBuilder();
        sb.append("R");
        sb.append(formatNumber(rowStatus.getNumber()));
        sb.append(":    ");

        String spots = Arrays
            .stream(rowStatus.getSpots())
            .map(s -> s.getType().substring(0,1) + "[" + formatNumber(s.getNumber()) + "]: " + s.getVehicle())
            .collect(Collectors.joining("#    "));

        sb.append(spots);

        return sb.toString();
    }

    private String formatNumber(int number) {
        return String.format("%02d", number);
    }
}
