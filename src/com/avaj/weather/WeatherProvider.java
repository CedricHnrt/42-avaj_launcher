package com.avaj.weather;

import com.avaj.aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider instance;
    private final String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        return instance = instance == null ? new WeatherProvider() : instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int seed = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % weather.length;
        return weather[seed];
    }
}
