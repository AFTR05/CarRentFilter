package com.example.carrent.service.Impl;

import com.example.carrent.controller.ModelFactoryController;
import com.example.carrent.repository.impl.ClientRepositoryImp;

public class CarRent {
    private final VehicleServiceImp vehicleServiceImp;
    private final ClientServiceImp clientServiceImp;
    private final LoanServiceImp loanServiceImp;
    private final ClientRepositoryImp clientRepositoryImp;

    public CarRent() {
        this.vehicleServiceImp = new VehicleServiceImp(this);
        this.clientServiceImp=new ClientServiceImp(this);
        this.loanServiceImp=new LoanServiceImp(this);
        this.clientRepositoryImp=new ClientRepositoryImp();
    }

    public VehicleServiceImp getVehicleServiceImp() {
        return vehicleServiceImp;
    }

    public ClientRepositoryImp getClientRepositoryImp() {
        return clientRepositoryImp;
    }

    public ClientServiceImp getClientServiceImp() {
        return clientServiceImp;
    }

    public LoanServiceImp getLoanServiceImp() {
        return loanServiceImp;
    }
}
