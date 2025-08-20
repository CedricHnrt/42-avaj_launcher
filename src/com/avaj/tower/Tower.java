package com.avaj.tower;

import com.avaj.aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public Tower() {}

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.toString() + "registered to weather tower.");
    }
    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
        System.out.println("Tower says: " + p_flyable.toString() + "unregistered from weather tower.");
    }
    protected void conditionChanged() {/*TODO: Implement weather condition changes*/}
}
