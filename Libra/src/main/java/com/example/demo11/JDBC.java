package com.example.demo11;
import Model.postUnit;
import javafx.print.PageOrientation;
import javafx.util.Pair;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

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
                set.setPostId(rs.getString("postid"));
                set.setCategory(rs.getString("category"));

                List<Integer> p = JDBC.like_dislike_count(rs.getString("postid"));
                set.setLikeCount(p.get(0));
                set.setDislikeCount(p.get(1));
                set.setCmntCount(p.get(2));

                /*int imgSetter = JDBC.isLikesOrDisliked(rs.getString("p_userid"), rs.getString("postid"));
                if(imgSetter == 1) {
                    set.setLikeImgUrl("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\likeFill.png");
                    set.setDislikeImgUrl("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\dislike.png");
                } else if(imgSetter == 2){
                    set.setLikeImgUrl("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\like.png");
                    set.setDislikeImgUrl("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\dislikeFill.png");
                } else{
                    set.setLikeImgUrl("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\like.png");
                    set.setDislikeImgUrl("C:\\Users\\Nahin\\Desktop\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\dislike.png");
                }*/
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
                set.setPostId(rs.getString("postid"));
                set.setCategory(rs.getString("category"));

                List<Integer> p = JDBC.like_dislike_count(rs.getString("postid"));
                set.setLikeCount(p.get(0));
                set.setDislikeCount(p.get(1));
                set.setCmntCount(p.get(2));

                setPost.add(set);
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
        return setPost;
    }
    public static List<Integer> like_dislike_count(String postID){
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        int likeCount = 0;
        int dislikeCount = 0;
        int commentCount = 0;

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();

            st.execute("select count(*) from likes where postid = "+postID+";");
            ResultSet rs = st.getResultSet();
            if(rs.next())
                likeCount = rs.getInt("count(*)");

            st.execute("select count(*) from dislikes where d_postid = "+postID+";");
            rs = st.getResultSet();
            if(rs.next())
                dislikeCount = rs.getInt("count(*)");

            st.execute("select count(*) from comments where c_postid = "+postID+";");
            rs = st.getResultSet();
            if(rs.next())
                commentCount = rs.getInt("count(*)");

        } catch (SQLException e) {
            System.out.println("Failed to connect like_dislike_count");
            e.printStackTrace();
        }
        List<Integer> p = new ArrayList<>();
        p.add(likeCount);
        p.add(dislikeCount);
        p.add(commentCount);
        return p;
    }

    public static Integer isLikedOrDisliked(String userID, String postID){
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        int likeCount = 0;
        int dislikeCount = 0;

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            st.execute("select count(*) from likes where userid = "+userID+" and  postid = "+postID+";");
            ResultSet rs = st.getResultSet();
            if(rs.next())
                likeCount = rs.getInt("count(*)");
            st.execute("select count(*) from dislikes where userid = "+userID+" and postid = "+postID+";");
            rs = st.getResultSet();
            if(rs.next())
                dislikeCount = rs.getInt("count(*)");
        } catch (SQLException e) {
            System.out.println("Failed to connect isLikesOrDisliked");
            e.printStackTrace();
        }
        if(likeCount == 0 && dislikeCount!= 0){
            return 2;
        } else if(likeCount !=0 && dislikeCount == 0){
            return 1;
        }else {
            return 0;
        }

    }
    public static void insertLike(String userID, String postID){
        System.out.println("inside the enter data portion");
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        String userId = UTILITY.generateString();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!! in enter data");
            Statement st = conn.createStatement();
            st.execute("insert into likes values('"+userID+"','"+postID+"')");
            st.execute("delete from dislikes where d_userid = "+userID+" and d_postid = "+postID+";");
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
    }

    public static void insertDislike(String userID, String postID){
        System.out.println("inside the enter data portion");
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!! in enter data");
            Statement st = conn.createStatement();
            st.execute("insert into dislikes values('"+userID+"','"+postID+"')");
            st.execute("delete from likes where userid = "+userID+" and postid = "+postID+";");
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
    }

    public static void insertComment(String userid, String postid, String commentbody){
        System.out.println("inside the enter data portion");
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database in comment entering");
            Statement st = conn.createStatement();
            st.execute("insert into comments values('"+postid+"','"+userid+"','"+commentbody+"');");
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
    }

    public static List<Pair<String, String>> fetchComments(String postid){
        System.out.println("inside the get user id portion");
        String url = "jdbc:mysql://localhost:3306/libra";
        String user = "root";
        String password = "yh56$$hHFHD45";
        List<Pair<String, String>> cmnts = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM comments where c_postid = '"+postid+"';");
            ResultSet rs = st.getResultSet();
            System.out.println("Connected to database comment fetching");
            while(rs.next()){
                String userid = rs.getString("c_userid");
                String body = rs.getString("cmntbody");
                Pair<String, String> p = new Pair<>(userid, body);
                cmnts.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect");
            e.printStackTrace();
        }
        return cmnts;
    }
}

