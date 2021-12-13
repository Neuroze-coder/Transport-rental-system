package com.accenture.russiaatc.irentservice.model.entity.enums;

import lombok.Getter;

@Getter
public enum TypeRent {

    IN_PROGRESS("IN PROGRESS"), FINISHED ("FINISHED");

    private final String name;

    TypeRent (String name) {
        this.name = name;
    }


}
