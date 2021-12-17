package com.accenture.russiaatc.irentservice.model.converters;

import com.accenture.russiaatc.irentservice.model.dto.ParkingDto;
import com.accenture.russiaatc.irentservice.model.entity.Parking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface ParkingMapper {

    @Mapping(source = "location", target = "area.center")
    @Mapping(source = "radius", target = "area.radiusInMeters")
    ParkingDto map (Parking parking);

    @Mapping(source = "area.center", target = "location")
    @Mapping(source = "area.radiusInMeters", target = "radius")
    Parking map (ParkingDto parkingDto);
}
