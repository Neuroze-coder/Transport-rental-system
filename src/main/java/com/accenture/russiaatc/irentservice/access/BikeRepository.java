package com.accenture.russiaatc.irentservice.access;

import com.accenture.russiaatc.irentservice.model.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository <Bike, Long> {
}
