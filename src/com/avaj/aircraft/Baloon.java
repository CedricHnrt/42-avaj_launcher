package com.avaj.aircraft;

import com.avaj.simulation.Logger;

import java.io.IOException;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() throws IOException {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                Logger.getInstance().log(this + ": Let's enjoy the good weather and take some pics.");
                this.coordinates.modifyLongitude(2);
                this.coordinates.modifyHeight(4);
                break;
            case "RAIN":
                Logger.getInstance().log(this + ": Damn you rain! You messed up my baloon.");
                this.coordinates.modifyHeight(-5);
                break;
            case "FOG":
                Logger.getInstance().log(this + ": Can't see a thing in this fog!");
                this.coordinates.modifyHeight(-3);
                break;
            case "SNOW":
                Logger.getInstance().log(this + ": It's snowing. We're gonna crash.");
                this.coordinates.modifyHeight(-15);
                break;
        }
        if (this.coordinates.getHeight() == 0) {
            Logger.getInstance().log(this + " landing.");
            this.weatherTower.unregister(this);
        }
    }
}
