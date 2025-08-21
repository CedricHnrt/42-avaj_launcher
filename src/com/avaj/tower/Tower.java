package com.avaj.tower;

import com.avaj.aircraft.Flyable;
import com.avaj.simulation.Logger;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Tower {
    private final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) throws IOException {
        this.observers.add(p_flyable);
        Logger.getInstance().log("Tower says: " + p_flyable.toString() + " registered to weather tower.");
    }
    public void unregister(Flyable p_flyable) throws IOException {
        this.observers.remove(p_flyable);
        Logger.getInstance().log("Tower says: " + p_flyable.toString() + " unregistered from weather tower.");
    }
    protected void conditionChanged() throws IOException {
        for (Flyable p_flyable : new ArrayList<>(observers)) {
            p_flyable.updateConditions();
        };
    }
}
