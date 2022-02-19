package com.example.parking.domain.model.parking;

import com.example.parking.domain.model.parking.status.RowStatus;
import com.example.parking.domain.model.parking.status.SpotStatus;
import com.example.parking.domain.model.vehicle.Bus;
import com.example.parking.domain.model.vehicle.Vehicle;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class Row {

    private int number;
    private Spot[] spots;

    public Row(int rowNumber, Spot[] spots) {
        this.number = rowNumber;
        this.spots = spots;
    }

    public Optional<SpotCoordinates[]> tryParkingVehicle(Vehicle vehicle) {
        int numberOfSpotsRequired = howManySpots(vehicle);
        if (enughSpotsInARow(numberOfSpotsRequired)) {
            return tryToFindAvailableSpots(vehicle, numberOfSpotsRequired);
        } else {
            return spotsNotFound();
        }
    }

    public void release(Vehicle vehicle) {
        throw new UnsupportedOperationException();
    }

    private Optional<SpotCoordinates[]> tryToFindAvailableSpots(Vehicle vehicle, int numberOfSpotsRequired) {
        Optional<Spot[]> foundSpots = findSpots(vehicle, numberOfSpotsRequired);
        if (foundSpots.isPresent()) {
            reserveSpots(vehicle, foundSpots.get());
            SpotCoordinates[] spotsFound = prepareSpotCoordinates(numberOfSpotsRequired, foundSpots.get());
            return Optional.of(spotsFound);
        } else {
            return spotsNotFound();
        }
    }

    private void reserveSpots(Vehicle vehicle, Spot[] spots) {
        for(Spot spot : spots) {
            spot.parkVehicle(vehicle);
        }
    }

    private SpotCoordinates[] prepareSpotCoordinates(int numberOfSpotsRequired, Spot[] spotsForCoordinates) {
        SpotCoordinates[] spotCoordinates = new SpotCoordinates[numberOfSpotsRequired];
        int i = 0;
        for(Spot spot : spotsForCoordinates) {
            spotCoordinates[i++] = new SpotCoordinates(spot.getNumber(), this.number);
        }
        return spotCoordinates;
    }

    private Optional<Spot[]> findSpots(Vehicle vehicle, int numberOfSpotsRequired) {
        Spot[] foundSpots = new Spot[numberOfSpotsRequired];
        int spotToCheck = 0;
        int foundSpotsCount = 0;
        while(foundSpotsCount < numberOfSpotsRequired && spotToCheck < spots.length) {
            if (spots[spotToCheck].isAvailable() && spots[spotToCheck].canFitVehicle(vehicle)) {
                foundSpots[foundSpotsCount] = spots[spotToCheck];
                foundSpotsCount++;
            } else {
                foundSpotsCount = 0;
            }
            spotToCheck++;
        }

        return foundSpotsCount == numberOfSpotsRequired ? Optional.of(foundSpots) : Optional.empty();
    }

    private Optional<SpotCoordinates[]> spotsNotFound() {
        return Optional.empty();
    }

    private boolean enughSpotsInARow(int numberOfSpotsRequired) {
        return spots.length >= numberOfSpotsRequired;
    }

    private int howManySpots(Vehicle vehicle) {
        if (vehicle instanceof Bus) {
            return 5;
        } else {
            return 1;
        }
    }

    RowStatus getStatus() {
        return new RowStatus(this.number, prepareSpotStatus());
    }

    private SpotStatus[] prepareSpotStatus() {
        return Arrays.stream(spots)
                     .map(s -> s.getStatus())
                     .collect(Collectors.toList())
                     .toArray(new SpotStatus[spots.length]);
    }
}
