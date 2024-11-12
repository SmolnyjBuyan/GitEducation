package models;

import java.time.LocalDate;

public abstract class Animal {
    private final String name;
    private final String color;
    private final LocalDate birthDate;
    private final int jumpHeightInCentimeters;
    private final int runDistanceInMeters;
    private final int swimDistanceInMeters;

    public Animal(String name, String color, LocalDate birth_date) {
        this.name = name;
        this.color = color;
        this.birthDate = birth_date;
        jumpHeightInCentimeters = generateJumpHeight();
        runDistanceInMeters = generateRunHeight();
        swimDistanceInMeters = generateSwimDistance();
    }

    public boolean run(int distance) {
        return distance <= getRunDistanceInMeters();
    }
    public boolean swim(int distance) {
        return distance <= getSwimDistanceInMeters();
    }
    public boolean jump(int height) {
        return height <= getJumpHeightInCentimeters();
    }

    abstract protected int getMaxJumpHeightInCentimeters();
    abstract protected int getMaxRunDistanceInMeters();
    abstract protected int getMaxSwimDistanceInMeters();

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getJumpHeightInCentimeters() {
        return jumpHeightInCentimeters;
    }

    public int getRunDistanceInMeters() {
        return runDistanceInMeters;
    }

    public int getSwimDistanceInMeters() {
        return swimDistanceInMeters;
    }

    protected int generateJumpHeight() {
        int max = getMaxJumpHeightInCentimeters();
        int min= (int) (max * 0.75);

        return min + (int)(Math.random() * ((max - min) + 1));
    }

    protected int generateRunHeight() {
        int max = getMaxRunDistanceInMeters();
        int min= (int) (max * 0.75);

        return min + (int)(Math.random() * ((max - min) + 1));
    }

    protected int generateSwimDistance() {
        int max = getMaxSwimDistanceInMeters();
        int min= (int) (max * 0.75);

        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
