package com.avaj.aircraft;

import java.io.IOException;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private static long idCounter = 0;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    protected static long nextId() {
        if (idCounter == Long.MAX_VALUE) {
            throw new IllegalStateException("Maximum number of aircraft reached.");
        }
        return ++idCounter;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
    }

    @Override
    public void updateConditions() throws IOException {/*Useless but needed to respect diagram*/}
}
