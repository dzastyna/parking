package com.example.parking.domain.model.parking.status;

public class RowStatus {
    private int number;
    private SpotStatus[] spots;

    public RowStatus(int number, SpotStatus[] spots) {
        this.number = number;
        this.spots = spots;
    }

    public int getNumber() {
        return this.number;
    }

    public SpotStatus[] getSpots() {
        return this.spots;
    }
}
