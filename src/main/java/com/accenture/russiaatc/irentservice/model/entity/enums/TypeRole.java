package com.accenture.russiaatc.irentservice.model.entity.enums;

import lombok.Getter;

@Getter
public enum TypeRole {
    ADMINISTRATOR("ADMINISTRATOR"), USER ("USER");

    private final String name;

    TypeRole(String name) {
        this.name = name;
    }

}
