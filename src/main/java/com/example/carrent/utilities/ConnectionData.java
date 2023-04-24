package com.example.carrent.utilities;

import com.example.carrent.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;

import static java.sql.Types.NULL;

public class ConnectionData {
    public static HashSet<Client> chargeDataSQL(){
        HashSet<Client> clients = new HashSet<>();
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/carrent";
        String user = "admin_user";
        String password = "admin";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM client");
            while (rs.next()){
                clients.add(new Client(rs.getString("nickname"),rs.getString("password"),rs.getInt("id")));
                System.out.println(rs.getString("nickname") + " añadido con exito al array");
            }
            statement.close();
            return clients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addClient(Client client){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/carrent";
        String user = "admin_user";
        String password = "admin";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            ps = connection.prepareStatement("INSERT INTO client VALUES (?,?,?)");
            ps.setInt(1, NULL);
            ps.setString(2, client.getNickname());
            ps.setString(3, client.getPassword());
            ps.executeUpdate();
            System.out.println("Conexion realizada con exito");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }
}
