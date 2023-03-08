package com.example.carrent.persistence;

import com.example.carrent.model.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class PersistenceClient {
    public static final String RUTE_ARCHIVE_CLIENT = "C:\\Users\\AFTR\\Documents\\Andres\\Programacion\\Java\\proyectosJava\\carRent\\src\\main\\java\\com\\example\\carrent\\data\\clients.txt";

    public static void saveClient(HashSet<Client> clients) throws IOException {
        String contenido="";
        for(Client client: clients) {
            contenido += client.getNickname() + "/" + client.getPassword() + "/" + client.getId() + "\n";
        }
        ArchiveUtil.saveArchive(RUTE_ARCHIVE_CLIENT, contenido, false);
    }

    public static HashSet<Client> chargeClient() throws FileNotFoundException, IOException {
        HashSet<Client> clients=new HashSet<Client>();
        System.out.println(ArchiveUtil.readArchive(RUTE_ARCHIVE_CLIENT).toString());
        System.out.println("sos");
        ArrayList<String> content = ArchiveUtil.readArchive(RUTE_ARCHIVE_CLIENT);
        String line = "";
        for (int i = 0;i<content.size(); i++) {
            Client client=new Client();
            line= content.get(i);
            client.setNickname(line.split("/")[0]);
            client.setPassword(line.split("/")[1]);
            client.setId(Integer.parseInt(line.split("/")[2]));
            clients.add(client);
        }
        return clients;
    }
}
