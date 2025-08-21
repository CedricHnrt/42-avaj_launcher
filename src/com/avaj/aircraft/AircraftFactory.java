package com.avaj.aircraft;

public class AircraftFactory {
    private static AircraftFactory instance;

    private AircraftFactory() {}

    public Flyable newAircraft(String p_type, String p_name, int p_longitude, int p_latitude, int p_height) {
        Coordinates p_coordinates = new Coordinates(p_longitude, p_latitude,  p_height);
        return switch (p_type) {
            case "Helicopter" -> new Helicopter(Aircraft.nextId(), p_name, p_coordinates);
            case "JetPlane" -> new JetPlane(Aircraft.nextId(), p_name, p_coordinates);
            case "Baloon" -> new Baloon(Aircraft.nextId(), p_name, p_coordinates);
            default -> throw new IllegalArgumentException("Unknown aircraft type: " + p_type);
        };
    }
    public static AircraftFactory getInstance() {
        return instance = instance == null ? new AircraftFactory() : instance;
    }
}
