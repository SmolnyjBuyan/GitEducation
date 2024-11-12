package models;

import java.time.LocalDate;

public class Dog extends Animal{
    public Dog(String name, String color, LocalDate birth_date) {
        super(name, color, birth_date);
    }

    @Override
    protected int getMaxJumpHeightInCentimeters() {
        return 100;
    }

    @Override
    protected int getMaxRunDistanceInMeters() {
        return 50000;
    }

    @Override
    protected int getMaxSwimDistanceInMeters() {
        return 1000;
    }
}
