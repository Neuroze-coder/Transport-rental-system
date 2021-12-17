package com.accenture.russiaatc.irentservice.model.converters;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.model.entity.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface RentMapper {

    Rent map (RentDto rentDto);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "startTime", target = "startDateTime")
    @Mapping(source = "endTime", target = "endDateTime")
    @Mapping(source = "transport", target = "vehicle")
    @Mapping(source = "transport.serial", target = "vehicle.serial")
    @Mapping(source = "startLocation", target = "startParking")
    @Mapping(source = "finalLocation", target = "finishParking")

    RentDto map(Rent rent);

}
