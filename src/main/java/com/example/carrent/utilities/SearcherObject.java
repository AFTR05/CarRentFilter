package com.example.carrent.utilities;

import com.example.carrent.model.Client;
import com.example.carrent.model.Vehicle;

import java.util.HashSet;

public class SearcherObject {
    public static Client getClient(Integer id, HashSet<Client> listPeople) {
        for (Client client : listPeople) {
            if(client.getId().equals(id)){return client;}
        }
        return null;
    }

    public static Client getClientId(String name,String password, HashSet<Client> listPeople) {
        for (Client client : listPeople) {
            if(client.getNickname().equals(name)&&client.getPassword().equals(password)){return client;}
        }
        return null;
    }
    public static Vehicle getVehicle(Integer id, HashSet<Vehicle> listAttraction){
        for (Vehicle vehicle:listAttraction){
            if (vehicle.getId().equals(id)){
                return vehicle;
            }
        }
        return null;
    }
}
