package com.accenture.russiaatc.irentservice.model.converters;


import com.accenture.russiaatc.irentservice.model.dto.TransportBikeDto;
import com.accenture.russiaatc.irentservice.model.dto.TransportDto;
import com.accenture.russiaatc.irentservice.model.dto.TransportShortDto;
import com.accenture.russiaatc.irentservice.model.entity.Bike;
import com.accenture.russiaatc.irentservice.model.entity.Scooter;
import com.accenture.russiaatc.irentservice.model.entity.Transport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface TransportMapper {
    TransportBikeDto entityBikeDto (Transport e);
    Transport BikeDtoEntity (TransportBikeDto e);

//    @Mapping(source = "serial", target = "regNumber")
    TransportShortDto entityShortDto (Transport e);
    Transport shortDtoEntity (TransportShortDto e);


    @Mapping(source = "parking", target = "parking")
    @Mapping(source = "parking.location", target = "parking.area.center")
    @Mapping(source = "parking.location", target = "geoPosition")
    @Mapping(source = "serial", target = "regNumber")
    @Mapping(source = "type", target = "type")
    TransportDto map (Bike t);

    @Mapping(source = "parking", target = "parking")
    @Mapping(source = "parking.location", target = "parking.area.center")
    @Mapping(source = "parking.location", target = "geoPosition")
    @Mapping(source = "serial", target = "regNumber")
    @Mapping(source = "type", target = "type")
    TransportDto map (Scooter t);

    default TransportDto map (Transport t) {
        if (t instanceof Bike) {
            return map((Bike)t);
        }else if (t instanceof Scooter){
            return map((Scooter) t);
        }else {
            throw new IllegalArgumentException();
        }
    }
}
