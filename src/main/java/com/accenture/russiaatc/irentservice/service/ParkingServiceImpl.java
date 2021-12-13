package com.accenture.russiaatc.irentservice.service;

import com.accenture.russiaatc.irentservice.access.ParkingRepository;
import com.accenture.russiaatc.irentservice.model.converters.LocationMapper;
import com.accenture.russiaatc.irentservice.model.converters.ParkingMapper;
import com.accenture.russiaatc.irentservice.model.dto.ParkingDto;
import com.accenture.russiaatc.irentservice.model.entity.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {

    ParkingRepository parkingRepository;
    ParkingMapper parkingConverter;
    LocationMapper locationConverter;

    @Autowired
    public ParkingServiceImpl(ParkingRepository parkingRepository, ParkingMapper parkingMapper, LocationMapper locationMapper) {
        this.parkingRepository = parkingRepository;
        this.parkingConverter = parkingMapper;
        this.locationConverter = locationMapper;
    }

    @Override
    public ParkingDto createParking(ParkingDto parkingDto) {
        Parking parking = new Parking();
        parking.setName(parking.getName());
        parking.setLocation(parking.getLocation());
        parking.setRadius(parking.getRadius());
        return parkingConverter.map(parkingRepository.save(parking));
    }

    @Override
    public ParkingDto saveParking(ParkingDto parkingDto) {
        Parking saveParking = parkingRepository.save(parkingConverter.map(parkingDto));
        return null;
    }

    @Override
    public void deleteParking(Long id) {
        parkingRepository.deleteById(id);

    }

    @Override
    public ParkingDto findById(Long id) {
        return parkingConverter.map(parkingRepository.findById(id).orElseThrow());
    }

    @Override
    public List<ParkingDto> findAll() {
        return parkingRepository.findAll()
                .stream()
                .map(parkingConverter::map)
                .collect(Collectors.toList());
    }
}
