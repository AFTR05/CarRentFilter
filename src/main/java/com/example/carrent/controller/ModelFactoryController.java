package com.example.carrent.controller;

import com.example.carrent.service.Impl.CarRent;
import com.example.carrent.service.ModelFactoryService;

public class ModelFactoryController implements ModelFactoryService {
    private CarRent carRent;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public CarRent getCarRent() {
        return carRent;
    }

    public ModelFactoryController() {
        carRent=new CarRent();
    }

    public void setCarRent(CarRent carRent) {
        this.carRent = carRent;
    }

    @Override
    public void createClient(String name, String password) {
        carRent.getClientServiceImp().createClient(name, password);
    }
}
