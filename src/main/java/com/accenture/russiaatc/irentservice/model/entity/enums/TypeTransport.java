package com.accenture.russiaatc.irentservice.model.entity.enums;

public enum TypeTransport {
    BIKE("BIKE"), SCOOTER ("SCOOTER"), ALL("ALL");

    private final String name;

    TypeTransport(String name) {
        this.name = name;
    }
}
