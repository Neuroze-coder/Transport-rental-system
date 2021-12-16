package com.accenture.russiaatc.irentservice.model.entity.enums;

public enum ConditionType {
    EXCELLENT("EXCELLENT"), GOOD("GOOD") , SATISFACTORY("SATISFACTORY");

    private final String name;

    ConditionType(String name) {
        this.name = name;
    }
}
