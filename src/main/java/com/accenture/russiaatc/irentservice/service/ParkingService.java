package com.accenture.russiaatc.irentservice.service;

import com.accenture.russiaatc.irentservice.model.dto.ParkingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParkingService {

    ParkingDto createParking (ParkingDto parkingDto);

    ParkingDto saveParking (ParkingDto parkingDto);

    void deleteParking (Long id);

    ParkingDto findById (Long id);

    List<ParkingDto> findAll();

}
