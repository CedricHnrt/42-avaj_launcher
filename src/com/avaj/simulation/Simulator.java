package com.avaj.simulation;

import com.avaj.aircraft.AircraftFactory;
import com.avaj.aircraft.Flyable;
import com.avaj.tower.WeatherTower;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <input_file>");
            return;
        }
        try {
            List<ScenarioEntry> entries = new ArrayList<>();
            int simulations = Parser.parseScenario(args[0], entries);
            List<Flyable> flyables = new ArrayList<>();
            WeatherTower weatherTower = new WeatherTower();
            for (ScenarioEntry entry : entries) {
                flyables.add(AircraftFactory.getInstance().newAircraft(entry.type, entry.name,
                        entry.longitude, entry.latitude, entry.height));
            }
            Simulator.run(simulations, flyables, weatherTower);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void run(int simulations, List<Flyable> flyables, WeatherTower weatherTower) {
        for (Flyable flyable : flyables) {
            flyable.registerTower(weatherTower);
        }
        while (simulations-- > 0) {
            weatherTower.changeWeather();
        }
    }
}