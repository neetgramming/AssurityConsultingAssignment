package com.neetgramming;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestUtil {
    public static HttpURLConnection getHTTPConnection(String apiRequestUrl) {
        HttpURLConnection conn;
        try {
            URL url = new URL(apiRequestUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static String getResponseBody(HttpURLConnection httpURLConnection) {
        String responseBody = "";
        try {
            if (httpURLConnection.getResponseCode() != 200)
                throw new RuntimeException("HTTP Response Code: "+httpURLConnection.getResponseCode());
            else {
                InputStream inputStream = httpURLConnection.getInputStream();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseBody;
    }

    public static HttpResponse getResponse(String url) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse httpResponse;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return httpResponse;
    }
}
