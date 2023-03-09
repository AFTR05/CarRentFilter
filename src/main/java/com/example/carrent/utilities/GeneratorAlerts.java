package com.example.carrent.utilities;

import com.example.carrent.model.Client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GeneratorAlerts {

    public static HashMap<String,String> generateMessageRegister(String name,String password,String confirmPassword) {
        HashMap<String,String> errores=new HashMap<>();
        if(name==""||name.isBlank()){
            errores.put("nickname","Nickname required");
        }
        if (password==""||password.isBlank()){
            errores.put("password","Password required");
        }
        if (confirmPassword==""||confirmPassword.isBlank()){
            errores.put("confirmpassword","You need to confirm the above password");
        }else if (confirmPassword!=password){
            errores.put("confirmpassword","The password is different of the confirm password");
        }
        return errores;
    }

    public static HashMap<String,String> generateMessageLogin(String name,String password) {
        HashMap<String,String> errores=new HashMap<>();
        if(name==""||name.isBlank()){
            errores.put("nickname","Nickname required");
        }
        if (password==""||password.isBlank()){
            errores.put("password","Password required");
        }
        if (password!=""&&name!=""&&LoginAction.DefaultLogin(name, password)==""){
            errores.put("nologin","The client does not exists");
        }
        return errores;
    }

}
