package com.example.carrent.persistence;

import com.example.carrent.controller.ModelFactoryController;
import com.example.carrent.model.Loan;
import com.example.carrent.model.Vehicle;
import com.example.carrent.service.Impl.CarRent;
import com.example.carrent.utilities.SearcherObject;
import com.example.carrent.utilities.TypeConverter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class PersistenceLoan {

    private static final CarRent carRent= ModelFactoryController.getInstance().getCarRent();
    public static final String RUTE_ARCHIVE_LOAN= "src/main/java/com/example/carrent/data/loan.txt";

    public static void saveVehicle(Loan loan) throws IOException {
        String contenido= loan.getBeginLoan()+"/"+loan.getVehicle().getId()+"/"+loan.getClient().getId()+"\n";
        ArchiveUtil.saveArchive(RUTE_ARCHIVE_LOAN, contenido, false);
    }

    public static HashSet<Loan> chargeLoan() throws FileNotFoundException, IOException {
        HashSet<Loan> loans=new HashSet<Loan>();
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_LOAN);
        String line = "";
        for (int i = 0;i<content.size(); i++) {
            Loan loan=new Loan();
            line= content.get(i);
            loan.setBeginLoan(LocalDateTime.parse(line.split("/")[0]));
            loan.setVehicle(SearcherObject.getVehicle(Integer.parseInt(line.split("/")[1]),carRent.getVehicleServiceImp().getListVehicles()));
            loan.setClient(SearcherObject.getClient(Integer.parseInt(line.split("/")[2]),carRent.getClientServiceImp().getListClients()));
            loans.add(loan);
        }
        return loans;
    }
}
