package com.example.carrent.service.Impl;

import com.example.carrent.model.Client;
import com.example.carrent.repository.impl.ClientRepositoryImp;
import com.example.carrent.service.ClientService;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;

public class ClientServiceImp implements ClientService {
    private HashSet<Client> listClients;
    private ClientRepositoryImp cri=new ClientRepositoryImp();

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
        Client client=new Client(name,password);
        listClients.add(client);
        cri.save(client);
    }

    @Override
    public HashSet<Client> listar() {
        return cri.list();
    }
    @Override
    public void update(Long id, Client client){
        cri.update(id, client);
    }
    @Override
    public Client getById(Long id) {
        return cri.byId(id);
    }
    @Override
    public void delete(Long id) {
        cri.delete(id);
    }



}
