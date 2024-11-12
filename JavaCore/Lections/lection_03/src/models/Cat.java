package models;

import java.time.LocalDate;

public class Cat extends Animal{
    private static int count;
    private final int id;

    public Cat(String name, String color, LocalDate birth_date) {
        super(name, color, birth_date);
        id = ++count;
    }

    @Override
    protected int getMaxJumpHeightInCentimeters() {
        return 200;
    }

    @Override
    protected int getMaxRunDistanceInMeters() {
        return 20000;
    }

    @Override
    protected int getMaxSwimDistanceInMeters() {
        return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                '}';
    }
}
