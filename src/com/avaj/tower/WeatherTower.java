package com.avaj.tower;

import com.avaj.aircraft.Coordinates;
import com.avaj.weather.WeatherProvider;

import java.io.IOException;

public class WeatherTower  extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }
    public void changeWeather() throws IOException {
        this.conditionChanged();
    }
}
