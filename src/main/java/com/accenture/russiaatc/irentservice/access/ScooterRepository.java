package com.accenture.russiaatc.irentservice.access;

import com.accenture.russiaatc.irentservice.model.entity.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterRepository extends JpaRepository <Scooter, Long> {
}
