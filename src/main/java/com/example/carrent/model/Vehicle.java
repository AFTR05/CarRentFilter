package com.example.carrent.model;

import java.lang.reflect.Type;

public class Vehicle {
    private String name;
    private TypeVehicle type;
    private static Integer id;

    public Vehicle(String name, TypeVehicle type) {
        this.name = name;
        this.type = type;
        id++;
    }
    public Vehicle(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeVehicle getType() {
        return type;
    }

    public void setType(TypeVehicle type) {
        this.type = type;
    }

    public void setId(Integer id) {
        Vehicle.id = id;
    }

    public Integer getId() {
        return id;
    }

}
