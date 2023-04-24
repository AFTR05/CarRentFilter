package com.example.carrent.model;

import jakarta.inject.Named;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.Type;
@SessionScoped
@Named
public class Vehicle implements Serializable {
    private String name;
    private TypeVehicle type;
    private Integer id;

    public Vehicle(String name, TypeVehicle type,Integer id) {
        this.name = name;
        this.type = type;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

}
