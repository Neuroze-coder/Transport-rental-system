package com.accenture.russiaatc.irentservice.model.converters;

import com.accenture.russiaatc.irentservice.model.dto.ParkingDto;
import com.accenture.russiaatc.irentservice.model.entity.Parking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ParkingMapper {

//    @Mapping(source = "location", target = "locationDto")
    ParkingDto map (Parking parking);

//    @Mapping(source = "locationDto", target = "location")
    Parking map (ParkingDto parkingDto);
}
