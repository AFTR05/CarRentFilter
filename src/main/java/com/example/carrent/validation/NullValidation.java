package com.example.carrent.validation;

import com.example.carrent.exception.InputException;

import javax.swing.*;

public class NullValidation {
    public static Boolean nullRegister(String name,String password,String confirmPassword){
        if(!(name.equals("") || password.equals("") || confirmPassword.equals(""))) {
            return true;
        }else {
            try {
                throw new InputException("Information is missing");
            }catch (InputException ie){
                return false;
            }
        }
    }

    public static Boolean nullLogin(String name,String password){
        if(!(name.equals("") || password.equals(""))) {
            return true;
        }else {
            try {
                throw new InputException("Information is missing");
            }catch (InputException ie){
                return false;
            }
        }
    }
}
