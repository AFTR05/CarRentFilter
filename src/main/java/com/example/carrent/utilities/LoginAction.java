package com.example.carrent.utilities;

import com.example.carrent.controller.ModelFactoryController;
import com.example.carrent.service.Impl.CarRent;


public class LoginAction {
    private static final CarRent carRent=ModelFactoryController.getInstance().getCarRent();

    public static String DefaultLogin(String name, String password){
        if (SearcherObject.getClientId(name,password,carRent.getClientServiceImp().getListClients())!=null){
            return "client";
        }
        return "";
    }

}
