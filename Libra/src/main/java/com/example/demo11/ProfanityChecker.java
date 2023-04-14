package com.example.demo11;

import org.apache.commons.net.nntp.NNTP;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfanityChecker {
    public static boolean containsProfanity(String text) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://neutrinoapi-bad-word-filter.p.rapidapi.com/bad-word-filter"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("X-RapidAPI-Key", "878ef824a3msh4bfc5b1c4b5a9e9p163e93jsndefeca901432")
                .header("X-RapidAPI-Host", "neutrinoapi-bad-word-filter.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("content="+text))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        Pattern pattern = Pattern.compile("\"is-bad\":(true|false)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(responseBody);
        boolean isBad=false;
        if (matcher.find()) {
            isBad = Boolean.parseBoolean(matcher.group(1));
            System.out.println("Is bad? " + isBad);
        }
        System.out.println("This is executed"+Boolean.toString(isBad));
        return  isBad;
    }
}

