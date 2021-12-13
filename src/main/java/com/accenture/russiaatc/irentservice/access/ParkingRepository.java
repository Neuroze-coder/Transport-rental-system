package com.accenture.russiaatc.irentservice.access;

import com.accenture.russiaatc.irentservice.model.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingRepository extends JpaRepository<Parking, Long>  {

}
