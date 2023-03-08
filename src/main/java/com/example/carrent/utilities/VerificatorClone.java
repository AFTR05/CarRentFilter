package com.example.carrent.utilities;

import com.example.carrent.model.Client;

import java.util.HashSet;

public class VerificatorClone {
    public static Boolean verifyNameProfile(String name, HashSet<Client> people){
        Boolean resultado=false;
        if (people.size()==0)resultado=true;
        for (Client client : people) {
            resultado = (name.equals(client.getNickname())) ? false : true;

            if (!resultado)break;
        }
        return resultado;
    }
}
