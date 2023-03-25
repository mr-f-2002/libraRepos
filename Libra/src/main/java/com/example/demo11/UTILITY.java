package com.example.demo11;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public static boolean checkEmail(String email) {
        final String EMAIL_REGEX = "^[a-z0-9+.-]+@[a-z0-9.-]+$";
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
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
    public static boolean checkPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}




