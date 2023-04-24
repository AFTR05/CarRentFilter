package com.example.carrent.service;

import com.example.carrent.model.Client;

import java.util.HashSet;
import java.util.List;

public interface ClientService {
    public void createClient(String name,String password);

    HashSet<Client> listar();

    void update(Long id, Client client);

    Client getById(Long id);

    void delete(Long id);
}
