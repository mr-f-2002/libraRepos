package com.example.demo11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    static Connection con= null;

    public static Connection fastconnect(){
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        try {
            if(con!=null){
                return con;
            }
             con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!!");
            return con;


        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }


        return null;
    }
}
