package com.avaj.simulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;

    private Logger() throws IOException {
        String filename = "simulation.txt";
        this.writer = new BufferedWriter(new FileWriter(filename));
    }

    public void log(String message) {
        try {
            this.writer.write(message);
            this.writer.newLine();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    public void close() {
        try {
            this.writer.close();
        } catch (IOException e) {
            System.out.println("Error while closing file: " + e.getMessage());
        }
    }

    static public Logger getInstance() throws IOException {
        return instance = instance == null ? new Logger() : instance;
    }

}
