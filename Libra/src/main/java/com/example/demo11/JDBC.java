package com.example.demo11;
import Model.postUnit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
        public static void EnterData(String firstname, String lastname, String studentid, String department, String email, String username, String pass) throws SQLException, IOException
        {
            System.out.println("inside the enter data portion");
            String url = "jdbc:mysql://localhost:3306/libra";
            String user = "root";
            String password = "yh56$$hHFHD45";
            String userId = UTILITY.generateString();

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to database!! in enter data");
                Statement st = conn.createStatement();
                st.execute("insert into userdata values('"+firstname+"','"+lastname+"', '"+studentid+"', '"+department+"', '"+email+"', '"+username+"', '"+pass+"', '"+userId+"')");
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
            Password = UTILITY.encrypt(Password);
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

    public static String getUserId(String s){
        System.out.println("inside the get user id portion");
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        String userId = UTILITY.generateString();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            st.execute("select userid from userdata where username = '"+s+"';");
            ResultSet rs = st.getResultSet();
            System.out.println("Connected to database!! in userID -_-");
            if(rs.next()){
                String userid = rs.getString("userid");
                return userid;
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
        return "failed";
    }

    public static void insertNewPost(String pid, String pbody, LocalDate pdate, String puserid, String pcategory){
        System.out.println("inside the enter data portion");
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        String userId = UTILITY.generateString();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!! in adding post");
            Statement st = conn.createStatement();
            st.execute("insert into posts values('"+pid+"','"+pbody+"', '"+java.sql.Date.valueOf(pdate)+"', '"+puserid+"', '"+pcategory+"', "+0+", "+0+")");
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
    }

    public static List<postUnit> allPost(){
        System.out.println("inside the get user id portion");
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        String userId = UTILITY.generateString();
        List<postUnit> setPost = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM posts order by creationdate DESC;");
            ResultSet rs = st.getResultSet();
            System.out.println("Connected to database!! in userID -_-");
            while(rs.next()){
                postUnit set = new postUnit();
                set.setUserid(rs.getString("p_userid"));
                set.setPostBody(rs.getString("body"));
                set.setDate(rs.getDate("creationdate").toLocalDate().toString());
                set.setLikeCount(rs.getInt("likecount"));
                set.setDislikeCount(rs.getInt("dislikecount"));
                set.setPostId(rs.getString("postid"));
                set.setCategory(rs.getString("category"));
                setPost.add(set);
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
        return setPost;
    }

    public static List<postUnit> myPost(String userID){
        System.out.println("inside the get user id portion");
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        String userId = UTILITY.generateString();
        List<postUnit> setPost = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM posts where p_userid = '"+userID+"' order by creationdate DESC;");
            ResultSet rs = st.getResultSet();
            System.out.println("Connected to database!! in userID -_-");
            while(rs.next()){
                postUnit set = new postUnit();
                set.setUserid(rs.getString("p_userid"));
                set.setPostBody(rs.getString("body"));
                set.setDate(rs.getDate("creationdate").toLocalDate().toString());
                set.setLikeCount(rs.getInt("likecount"));
                set.setDislikeCount(rs.getInt("dislikecount"));
                set.setPostId(rs.getString("postid"));
                set.setCategory(rs.getString("category"));
                setPost.add(set);
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
        return setPost;
    }
}

