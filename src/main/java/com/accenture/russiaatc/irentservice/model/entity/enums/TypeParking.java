package com.accenture.russiaatc.irentservice.model.entity.enums;

import lombok.Getter;

@Getter
public enum TypeParking {
    FOR_BIKE("FOR BIKE"), FOR_SCOOTER ("FOR SCOOTER"), FOR_ALL ("FOR ALL");

    private final String name;

    TypeParking (String name) {
        this.name = name;
    }
}
