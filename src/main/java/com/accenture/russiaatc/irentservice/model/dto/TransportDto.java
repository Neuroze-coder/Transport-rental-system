package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.TransportType;
import com.accenture.russiaatc.irentservice.model.entity.enums.TransportState;

import lombok.Data;


@Data

public class TransportDto {

    private Long id;
    private String condition;
    private TransportType type;
    private ParkingDto parkingDto;
    private String serial;
    private Integer chargeLevel;
    private Integer maxSpeed;
    private TransportState state;

}
