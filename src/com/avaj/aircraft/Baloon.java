package com.avaj.aircraft;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        //TODO: Implement baloon-specific weather update logic
    }
}
