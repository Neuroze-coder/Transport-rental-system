package com.accenture.russiaatc.irentservice.model.entity.enums;

public enum TypeCondition {
    EXCELLENT("EXCELLENT"), GOOD("GOOD") , SATISFACTORY("SATISFACTORY");

    private final String name;

    TypeCondition(String name) {
        this.name = name;
    }
}
