package com.example.carrent.model;

public enum TypeVehicle {
    MOTORCICLE("Motorcycle"),CAR("Car");
    private String type;
    TypeVehicle(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

}
