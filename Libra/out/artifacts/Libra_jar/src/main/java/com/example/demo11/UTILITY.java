package com.example.demo11;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UTILITY {
    private static final String DATE_FORMAT = "yyyyMMddHHmmss";

    public static String generateString() {
        String dateString = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        return dateString;
    }
    public static String encrypt(String input) {
        int key = 3;
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int code = (int) c;
            int shifted = code + key;
            char encryptedChar = (char) shifted;
            output += encryptedChar;
        }
        return output;
    }
    public static String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static boolean checkEmail(String email) {
        final String EMAIL_REGEX = "^[a-z0-9+.-]+@iut-dhaka\\.edu$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean checkStudentId(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkUsername(String username){
        String pattern = "^[a-z0-9_]+$";
        return username.matches(pattern);
    }
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*]).{8,}$";
    public static boolean checkPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static String getLikeImg(){
        return "C:\\Users\\Nahin\\Desktop\\ \\sem_2_2\\Visual Programming Lab\\FinalProject\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\like.png";
    }
    public static String getLikeFillImg(){
        return "C:\\Users\\Nahin\\Desktop\\ \\sem_2_2\\Visual Programming Lab\\FinalProject\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\likeFill.png";
    }
    public static String getDislikeImg(){
        return "C:\\Users\\Nahin\\Desktop\\ \\sem_2_2\\Visual Programming Lab\\FinalProject\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\dislike.png";
    }
    public static String getDisikeFillImg(){
        return "C:\\Users\\Nahin\\Desktop\\ \\sem_2_2\\Visual Programming Lab\\FinalProject\\libraRepos\\Libra\\src\\main\\resources\\com\\example\\demo11\\dislikeFill.png";
    }

    public static void sendOTP(String otp, String to) throws MessagingException, RuntimeException {
            String message = "Your otp for signing up in Libra : " + otp;
            String subject = "Sending otp to signup";
            String from = "otpsender@gmail.com";
            //String to = "jjonasbbb@gmail.com";
            sendMail(message, subject, from, to);
        }
    public static void sendMail(String message, String subject, String from, String to) throws MessagingException {
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        //System.out.println(properties);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("arusha38ahsan@gmail.com","fhvwwfjxbezkojdx");
            }
        });
        session.setDebug(true);

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(from);
        msg.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(to)});
        msg.setSubject(subject);
        msg.setText(message);
        Transport.send(msg);
        System.out.println("msg sending done....");
    }
    public static String generateOtp(){
        int otp = new Random().nextInt(900000) + 100000;
        return String.valueOf(otp);
    }
}





