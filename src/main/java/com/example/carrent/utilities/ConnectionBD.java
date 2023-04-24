package com.example.carrent.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    private static String url="jdbc:mysql://localhost:3306/carrent";
    private static String user="root";
    private static String password="andreS0503";
    private static Connection connection;
    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url,user,password);
    }
}
