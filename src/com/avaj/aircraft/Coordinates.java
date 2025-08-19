package com.avaj.aircraft;

public class Coordinates {
    private final int longitude;
    private final int latitude;
    private final int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        if (p_longitude < 0) {
            throw new IllegalArgumentException("Longitude cannot be negative");
        }
        if (p_latitude < 0) {
            throw new IllegalArgumentException("Latitude cannot be negative");
        }
        if (p_height < 0 || p_height > 100) {
            throw new IllegalArgumentException("Height must be between 0 and 100");
        }
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() {return this.longitude;}
    public int getLatitude() {return this.latitude;}
    public int getHeight() {return this.height;}
}
