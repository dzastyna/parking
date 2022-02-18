package com.example.parking.domain.model.parking;

public class SpotCoordinates {
    private int spotNo;
    private int rowNo;

    public SpotCoordinates(int spotNo, int rowNo) {
        this.spotNo = spotNo;
        this.rowNo = rowNo;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public int getRowNo() {
        return rowNo;
    }
}
