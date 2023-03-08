package com.example.carrent.utilities;

import com.example.carrent.model.TypeVehicle;

public class TypeConverter {
    public static TypeVehicle stringToType(String type){
        if(type.equals(TypeVehicle.CAR.getType())){
            return TypeVehicle.CAR;
        }
        if(type.equals(TypeVehicle.MOTORCICLE.getType())){
            return TypeVehicle.MOTORCICLE;
        }else return null;
    }
}
