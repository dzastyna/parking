package com.example.parking.addons.adapter.primary;

import com.example.parking.infrastructure.adapter.secondary.ParkingJpaRepository;
import com.example.parking.infrastructure.adapter.secondary.entity.ParkingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ParkingLotJpaRepoTestRest {

    @Autowired
    private ParkingJpaRepository repo;

    @PostMapping("/jpaSaveParkingLot")
    public String saveParkingLot(@RequestBody ParkingLotJpaRepoTestRequest request) {
        ParkingEntity pe = createParking(request);
        repo.save(pe);
        return "Parking " + pe.getId() + " saved.";
    }

    @GetMapping("/jpaAllParkingLots")
    public List<String> findAllParkingLots() {
        List<ParkingEntity> pe = repo.findAll();
        return pe.stream().map(x -> x.getId()).collect(Collectors.toList());
    }

    private ParkingEntity createParking(
        @RequestBody ParkingLotJpaRepoTestRequest request) {
        ParkingEntity pe = new ParkingEntity();
        pe.setId(request.getName());
        return pe;
    }
}
