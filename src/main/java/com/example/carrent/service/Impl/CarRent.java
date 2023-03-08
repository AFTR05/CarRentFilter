package com.example.carrent.service.Impl;

import com.example.carrent.controller.ModelFactoryController;

public class CarRent {
    private final VehicleServiceImp vehicleServiceImp;
    private final ClientServiceImp clientServiceImp;
    private final LoanServiceImp loanServiceImp;

    public CarRent() {
        this.vehicleServiceImp = new VehicleServiceImp(this);
        this.clientServiceImp=new ClientServiceImp(this);
        this.loanServiceImp=new LoanServiceImp(this);
    }

    public VehicleServiceImp getVehicleServiceImp() {
        return vehicleServiceImp;
    }

    public ClientServiceImp getClientServiceImp() {
        return clientServiceImp;
    }

    public LoanServiceImp getLoanServiceImp() {
        return loanServiceImp;
    }
}
