package com.accenture.russiaatc.irentservice.model.converters;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.model.entity.Rent;
import org.springframework.stereotype.Service;

@Service
public class RentConverter {
    public static Rent fromRentDtoToRent (RentDto rentDto) {
        Rent rent = new Rent();
        rent.setId(rentDto.getId());
        rent.setStatus(rentDto.getStatus());
        rent.setStartTime(rentDto.getStartTime());
        rent.setEndTime(rentDto.getEndTime());
        return rent;
    }

    public static RentDto fromRentToRentDto (Rent rent) {
        return RentDto.builder()
                .id(rent.getId())
                .status(rent.getStatus())
                .startTime(rent.getStartTime())
                .endTime(rent.getEndTime())
                .build();
    }
}
