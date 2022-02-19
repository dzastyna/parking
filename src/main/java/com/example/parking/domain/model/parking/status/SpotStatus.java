package com.example.parking.domain.model.parking.status;

public class SpotStatus {
    private String vehicle;

    private int number;

    private String type;

    public SpotStatus(String type, int number, String vehicle) {
        this.type = type;
        this.number = number;
        this.vehicle = vehicle;
    }

    public int getNumber() {
        return this.number;
    }

    public String getType() {
        return this.type;
    }

    public String getVehicle() {
        return this.vehicle;
    }
}
