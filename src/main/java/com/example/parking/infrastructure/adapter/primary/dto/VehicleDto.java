package com.example.parking.infrastructure.adapter.primary.dto;

public class VehicleDto {
    private String licencePlates;
    private VehicleType vehicleType;

    public String getLicencePlates() {
        return licencePlates;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setLicencePlates(String licencePlates) {
        this.licencePlates = licencePlates;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
