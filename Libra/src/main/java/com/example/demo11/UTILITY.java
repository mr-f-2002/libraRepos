package com.example.demo11;

import javafx.fxml.FXML;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UTILITY {
    private static final String DATE_FORMAT = "yyyyMMddHHmmss";

    public static String generateString() {
        String dateString = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        return dateString;
    }
    @FXML
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
}
