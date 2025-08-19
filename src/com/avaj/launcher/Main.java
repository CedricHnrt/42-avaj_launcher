package com.avaj.launcher;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <input_file>");
            return;
        }

        try {
            System.out.println("Reading input from: " + args[0]);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}