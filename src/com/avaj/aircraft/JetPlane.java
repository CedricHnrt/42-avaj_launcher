package com.avaj.aircraft;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                System.out.println(this + ": Sun is shining, let's fly higher!");
                this.coordinates.modifyLatitude(10);
                this.coordinates.modifyHeight(2);
                break;
            case "RAIN":
                System.out.println(this + ": It's raining. Better watch out for lightnings.");
                this.coordinates.modifyLatitude(5);
                break;
            case "FOG":
                System.out.println(this + ": Hard to see anything in this fog.");
                this.coordinates.modifyLatitude(1);
                break;
            case "SNOW":
                System.out.println(this + ": OMG! Winter is coming!");
                this.coordinates.modifyHeight(-7);
                break;
        }
        if (this.coordinates.getHeight() == 0) {
            System.out.println(this + " landing.");
            this.weatherTower.unregister(this);
        }
    }
}
