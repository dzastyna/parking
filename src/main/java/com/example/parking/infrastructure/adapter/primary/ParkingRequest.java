package com.example.parking.infrastructure.adapter.primary;

public class ParkingRequest {
    private Vehicle vehicle;
    private String parkingId;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }
}
