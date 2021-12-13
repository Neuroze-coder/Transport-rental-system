package com.accenture.russiaatc.irentservice.model.converters;

import com.accenture.russiaatc.irentservice.model.dto.ParkingDto;
import com.accenture.russiaatc.irentservice.model.entity.Parking;
import org.mapstruct.Mapper;


@Mapper
public interface ParkingMapper {


    ParkingDto map (Parking parking);

//
    Parking map (ParkingDto parkingDto);
}
