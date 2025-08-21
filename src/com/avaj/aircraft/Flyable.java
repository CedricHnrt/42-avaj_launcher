package com.avaj.aircraft;

import com.avaj.tower.WeatherTower;

import java.io.IOException;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions() throws IOException;

    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
