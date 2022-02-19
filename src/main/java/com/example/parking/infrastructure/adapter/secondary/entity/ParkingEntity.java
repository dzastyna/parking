package com.example.parking.infrastructure.adapter.secondary.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO
@Entity
@Table(name="PARKING")
public class ParkingEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
