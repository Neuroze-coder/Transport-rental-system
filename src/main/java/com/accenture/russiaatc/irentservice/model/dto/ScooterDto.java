package com.accenture.russiaatc.irentservice.model.dto;

import lombok.Data;

@Data
public class ScooterDto extends TransportDto{

    private int maxSpeed;

    private int chargeLevel;
}
