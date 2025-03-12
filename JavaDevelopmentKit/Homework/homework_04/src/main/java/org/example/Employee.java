package org.example;

public class Employee {
    private int id;
    private String phoneNumber;
    private String name;
    private int experienceInYears;

    public Employee(int id, String phoneNumber, String name, int experienceInYears) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experienceInYears = experienceInYears;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    @Override
    public String toString() {
        return id + "." + name;
    }
}
