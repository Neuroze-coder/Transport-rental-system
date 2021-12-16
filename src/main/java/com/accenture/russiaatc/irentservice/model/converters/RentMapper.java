package com.accenture.russiaatc.irentservice.model.converters;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.model.entity.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface RentMapper {

    Rent map (RentDto rentDto);

//    @Mapping(source = "user", target = "userLoginDto")
//    @Mapping(source = "transport", target = "transportShortDto")
    RentDto map(Rent rent);

}
