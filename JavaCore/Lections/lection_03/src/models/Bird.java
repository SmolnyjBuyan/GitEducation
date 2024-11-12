package models;

import java.time.LocalDate;

public class Bird extends Animal{
    public Bird(String name, String color, LocalDate birth_date) {
        super(name, color, birth_date);
    }

    @Override
    protected int getMaxJumpHeightInCentimeters() {
        return 10;
    }

    @Override
    protected int getMaxRunDistanceInMeters() {
        return 100;
    }

    @Override
    protected int getMaxSwimDistanceInMeters() {
        return 100;
    }
}
