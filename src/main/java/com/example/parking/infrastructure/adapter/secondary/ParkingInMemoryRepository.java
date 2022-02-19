package com.example.parking.infrastructure.adapter.secondary;

import com.example.parking.domain.model.parking.CompactSpot;
import com.example.parking.domain.model.parking.LargeSpot;
import com.example.parking.domain.model.parking.MotorcycleSpot;
import com.example.parking.domain.model.parking.ParkingLot;
import com.example.parking.domain.model.parking.Row;
import com.example.parking.domain.model.parking.Spot;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ParkingInMemoryRepository {

    private Map<String, ParkingLot> parkingLots = new HashMap<>();

    public ParkingInMemoryRepository() {
        createParkingLots();
    }

    public Optional<ParkingLot> findById(String id) {
        ParkingLot pl = parkingLots.get(id);
        return pl == null ? Optional.empty() : Optional.of(pl);
    }

    public Map<String, ParkingLot> findAll() {
        return parkingLots;
    }

    private void createParkingLots() {
        ParkingLot p1 = createParkingLot1();

        parkingLots.put("P-1", p1);
    }

    private ParkingLot createParkingLot1() {

        int rowIdx = 0;
        int rowNo = 0;
        Row[] rows = new Row[6];

        int sNo;
        int sIdx;

        Spot[] spots = new Spot[7];
        sNo = 0;
        sIdx  = 0;
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        rows[rowIdx++] = new Row(rowNo++, spots);

        spots = new Spot[7];
        sIdx = 0;
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new MotorcycleSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        rows[rowIdx++] = new Row(rowNo++, spots);

        spots = new Spot[8];
        sIdx = 0;
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        rows[rowIdx++] = new Row(rowNo++, spots);

        sIdx = 0;
        spots = new Spot[10];
        spots[sIdx++] = new MotorcycleSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new MotorcycleSpot(++sNo);
        rows[rowIdx++] = new Row(rowNo++, spots);

        sIdx = 0;
        spots = new Spot[10];
        spots[sIdx++] = new MotorcycleSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new MotorcycleSpot(++sNo);
        rows[rowIdx++] = new Row(rowNo++, spots);

        sIdx = 0;
        spots = new Spot[10];
        spots[sIdx++] = new MotorcycleSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new CompactSpot(++sNo);
        spots[sIdx++] = new LargeSpot(++sNo);
        spots[sIdx++] = new MotorcycleSpot(++sNo);
        rows[rowIdx++] = new Row(rowNo++, spots);

        return new ParkingLot(rows);
    }
}
