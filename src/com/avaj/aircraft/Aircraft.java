package com.avaj.aircraft;

public class Aircraft {
    protected long id;
    protected String type;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String type, String name, Coordinates coordinates) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return this.type + "#" + this.name + "(" + this.id + ")";
    }
}
