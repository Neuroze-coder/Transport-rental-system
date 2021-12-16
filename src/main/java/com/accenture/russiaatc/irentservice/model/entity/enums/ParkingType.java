package com.accenture.russiaatc.irentservice.model.entity.enums;

import lombok.Getter;

@Getter
public enum ParkingType {
    FOR_BIKE("FOR BIKE"), FOR_SCOOTER ("FOR SCOOTER"), FOR_ALL ("FOR ALL");

    private final String name;

    ParkingType(String name) {
        this.name = name;
    }
}
