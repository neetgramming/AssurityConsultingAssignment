package com.neetgramming.request_util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CategoryRequestUtil {
    public static HttpResponse<String> getResponse(String url) {
        HttpResponse<String> httpResponse;
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            try {
                httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return httpResponse;
    }
}
