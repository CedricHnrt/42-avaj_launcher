package com.avaj.aircraft;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                System.out.println(this + ": Let's enjoy the good weather and take some pics.");
                this.coordinates.modifyLongitude(2);
                this.coordinates.modifyHeight(4);
                break;
            case "RAIN":
                System.out.println(this + ": Damn you rain! You messed up my baloon.");
                this.coordinates.modifyHeight(-5);
                break;
            case "FOG":
                System.out.println(this + ": Can't see a thing in this fog!");
                this.coordinates.modifyHeight(-3);
                break;
            case "SNOW":
                System.out.println(this + ": It's snowing. We're gonna crash.");
                this.coordinates.modifyHeight(-15);
                break;
        }
        if (this.coordinates.getHeight() == 0) {
            System.out.println(this + " landing.");
            this.weatherTower.unregister(this);
        }
    }
}
