package com.example.demo11;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;

public class JDBC {
        public static void EnterData(String firstname, String lastname, String studentid, String department, String email, String username, String pass) throws SQLException, IOException
        {
            System.out.println("inside the enter data portion");
            String url = "jdbc:mysql://localhost:3306/libra";
            String user = "root";
            String password = "yh56$$hHFHD45";

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to database!! in enter data");
                Statement st = conn.createStatement();
                st.execute("insert into userdata values('"+firstname+"','"+lastname+"', '"+studentid+"', '"+department+"', '"+email+"', '"+username+"', '"+pass+"')");
            } catch (SQLException e) {
                System.out.println("Failed to connect");
                e.printStackTrace();
            }
        }

    public static boolean checkUsernameAndMail(String Username, String Email) throws SQLException, IOException
    {
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        ResultSet rs = null;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!!");
            Statement statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM userdata WHERE username = '"+Username+"' OR email = '"+Email+"'");
            System.out.println("rs executed");
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
        int size = 0;
        while(rs.next()){
            size++;
        }
        System.out.println(size);
        if (size >= 1) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkEntry (String Username, String Password) throws SQLException {
        String sql = "INSERT INTO userdata (firstname, lastname, studentid, department, email, username, pass) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        ResultSet rs = null;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!!");
            Statement statement = conn.createStatement();
            Password = Controller.encrypt(Password);
            rs = statement.executeQuery("SELECT * FROM userdata WHERE username = '"+Username+"' AND password = '"+Password+"'");
            System.out.println("rs executed");
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
        int size = 0;
        while(rs.next()){
            size++;
        }
        System.out.println(size);
        if (size >= 1) {
            return true;
        } else {
            return false;
        }
    }
}

