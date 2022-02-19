package com.example.parking.domain.model.parking.status;

public class ParkingStatus {
    private String name;
    private RowStatus[] rows;

    public ParkingStatus(String name, RowStatus[] rows) {
        this.name = name;
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public RowStatus[] getRows() {
        return rows;
    }
}
