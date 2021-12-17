package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.TransportType;
import com.accenture.russiaatc.irentservice.model.entity.enums.TransportState;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TransportBikeDto {
    private Long id;
    private String condition;
    private TransportType type;
    private ParkingDto parkingDto;
    private String regNumber;
    private TransportState state;
}

