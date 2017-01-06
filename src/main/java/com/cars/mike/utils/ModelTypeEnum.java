package com.cars.mike.utils;


public enum ModelTypeEnum {

    SUV("SUV"),
    CONVERTIBLE("CONVERTIBLE"),
    COUPE("COUPE"),
    PICKUP("PICKUP"),
    SEDAN("SEDAN"),
    HATCHBACK("HATCHBACK");

    private final String string;

    private ModelTypeEnum(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
