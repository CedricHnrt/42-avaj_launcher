package com.avaj.aircraft;

import com.avaj.simulation.Logger;

import java.io.IOException;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() throws IOException {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                Logger.getInstance().log(this + ": What a sunny day! Enjoying the view from up here.");
                this.coordinates.modifyLongitude(10);
                this.coordinates.modifyHeight(2);
                break;
            case "RAIN":
                Logger.getInstance().log(this + ": Damn rain, my blades are getting heavy.");
                this.coordinates.modifyLongitude(5);
                break;
            case "FOG":
                Logger.getInstance().log(this + ": Visibility is terrible, almost flying blind.");
                this.coordinates.modifyLongitude(1);
                break;
            case "SNOW":
                Logger.getInstance().log(this + ": My rotor is going to freeze!");
                this.coordinates.modifyHeight(-12);
                break;
        }
        if (this.coordinates.getHeight() == 0) {
            Logger.getInstance().log(this + " landing.");
            this.weatherTower.unregister(this);
        }
    }
}
