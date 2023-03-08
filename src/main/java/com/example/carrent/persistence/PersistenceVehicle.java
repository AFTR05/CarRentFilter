package com.example.carrent.persistence;

import com.example.carrent.model.Client;
import com.example.carrent.model.Vehicle;
import com.example.carrent.utilities.TypeConverter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class PersistenceVehicle {
    public static final String RUTE_ARCHIVE_VEHICLE= "src/main/java/com/example/carrent/data/vehicles.txt";

    public static void saveVehicle(Vehicle vehicle) throws IOException {
        String contenido= vehicle.getName()+"/"+vehicle.getType().getType()+"/"+vehicle.getId()+"\n";
        ArchiveUtil.saveArchive(RUTE_ARCHIVE_VEHICLE, contenido, false);
    }

    public static HashSet<Vehicle> chargeVehicle() throws FileNotFoundException, IOException {
        HashSet<Vehicle> vehicles = new HashSet<Vehicle>();
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_VEHICLE);
        String line = "";

        for (int i = 0;i<content.size(); i++) {
            Vehicle vehicle=new Vehicle();
            line= content.get(i);
            vehicle.setName(line.split("/")[0]);
            vehicle.setType(TypeConverter.stringToType(line.split("/")[1]));
            vehicle.setId(Integer.parseInt(line.split("/")[2]));
            vehicles.add(vehicle);
        }
        return vehicles;
    }
}
