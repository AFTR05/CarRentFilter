package com.example.carrent.service.Impl;

import com.example.carrent.model.Client;
import com.example.carrent.service.ClientService;

import java.util.HashSet;

public class ClientServiceImp implements ClientService {
    private HashSet<Client> listClients;

    private final CarRent carRent;

    public CarRent getCarRent() {
        return carRent;
    }

    public ClientServiceImp(CarRent carRent) {
        this.carRent = carRent;
    }

    public HashSet<Client> getListClients() {
        return listClients;
    }

    public void setListClients(HashSet<Client> listClients) {
        this.listClients = listClients;
    }

    @Override
    public void createClient(String name, String password) {
        listClients.add(new Client(name,password));
    }
}
