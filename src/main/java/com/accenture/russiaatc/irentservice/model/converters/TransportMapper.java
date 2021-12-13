package com.accenture.russiaatc.irentservice.model.converters;


import com.accenture.russiaatc.irentservice.model.dto.TransportBikeDto;
import com.accenture.russiaatc.irentservice.model.dto.TransportDto;
import com.accenture.russiaatc.irentservice.model.dto.TransportShortDto;
import com.accenture.russiaatc.irentservice.model.entity.Bike;
import com.accenture.russiaatc.irentservice.model.entity.Scooter;
import com.accenture.russiaatc.irentservice.model.entity.Transport;
import org.mapstruct.Mapper;


@Mapper
public interface TransportMapper {
    TransportBikeDto entityBikeDto (Transport e);
    Transport BikeDtoEntity (TransportBikeDto e);
    TransportShortDto entityShortDto (Transport e);
    Transport shortDtoEntity (TransportShortDto e);

    TransportDto map (Bike t);
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
