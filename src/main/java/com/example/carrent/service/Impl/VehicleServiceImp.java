package com.example.carrent.service.Impl;

import com.example.carrent.model.Vehicle;

import java.util.HashSet;

public class VehicleServiceImp {
    private HashSet<Vehicle> listVehicles;

    private final CarRent carRent;

    public VehicleServiceImp(CarRent carRent) {
        this.carRent = carRent;
    }

    public CarRent getCarRent() {
        return carRent;
    }

    public HashSet<Vehicle> getListVehicles() {
        return listVehicles;
    }

    public void setListVehicles(HashSet<Vehicle> listVehicles) {
        this.listVehicles = listVehicles;
    }
}
