package com.example.parking.infrastructure.adapter.secondary;

import com.example.parking.infrastructure.adapter.secondary.entity.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO
public interface ParkingJpaRepository extends JpaRepository<ParkingEntity, Long> {
}
