package com.avaj.simulation;

import java.io.*;
import java.util.*;

public class Parser {
    public static int parseScenario(String filename, List<ScenarioEntry> entries) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();

        if  (line == null) {
            throw new IOException("File is empty.");
        }
        int simulations = Integer.parseInt(line.trim());
        if  (simulations < 1) {
            throw new IOException("Invalid simulations.");
        }
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length != 5) {
                throw new IOException("Line is invalid.");
            }
            String type = parts[0];
            String name = parts[1];
            int longitude = Integer.parseInt(parts[2]);
            int latitude = Integer.parseInt(parts[3]);
            int height = Integer.parseInt(parts[4]);

            if (longitude < 0 || latitude < 0 || height < 0) {
                throw new IOException("Negatives coordinates.");
            }
            if (height > 100) {
                throw new IOException("Height is greater than 100.");
            }
            entries.add(new ScenarioEntry(type, name, longitude, latitude, height));
        }
        br.close();
        return simulations;
    }
}
