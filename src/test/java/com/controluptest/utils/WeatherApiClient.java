package com.controluptest.utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApiClient {

    private static final String API_KEY = ConfigLoader.get("weather.api.key");
    private static final String BASE_URL = ConfigLoader.get("weather.api.base.url");

    public static BigDecimal getCurrentTemperatureFahrenheit(String zipCode) {
        try {
            String queryUrl = String.format("%s?key=%s&q=%s", BASE_URL, API_KEY, zipCode);
            HttpURLConnection connection = (HttpURLConnection) new URL(queryUrl).openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed to fetch weather data. HTTP Status: " + connection.getResponseCode());
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String response = reader.readLine();
                return new JSONObject(response).getJSONObject("current").getBigDecimal("temp_f");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching weather data", e);
        }
    }
}
