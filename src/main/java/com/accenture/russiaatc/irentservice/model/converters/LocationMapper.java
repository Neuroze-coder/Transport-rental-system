package com.accenture.russiaatc.irentservice.model.converters;

import com.accenture.russiaatc.irentservice.model.dto.LocationDto;
import com.accenture.russiaatc.irentservice.model.entity.Location;
import org.mapstruct.Mapper;

@Mapper
public interface LocationMapper {
    LocationDto map (Location location);
    Location map (LocationDto locationDto);
}
