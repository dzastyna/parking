package com.example.parking.infrastructure.adapter.primary.dto;

import com.example.parking.infrastructure.adapter.primary.dto.VehicleDto;

public class ParkVehicleRequest {
    private VehicleDto vehicle;
    private String parkingId;

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }
}
