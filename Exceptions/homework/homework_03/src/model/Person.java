package model;

import util.Gender;

import java.time.LocalDate;

public class Person {
    public static int fieldsCount = Person.class.getDeclaredMethods().length - 1;
    private String lastName;
    private String firstName;
    private String middleName;

    private long phoneNumber;
    private Gender gender;
    private LocalDate birthDate;

    public Person(String lastName, String firstName, String middleName, long phoneNumber, Gender gender, LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Person() {
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return STR."<\{lastName}><\{firstName}><\{middleName}><\{birthDate}><\{phoneNumber}><\{gender.getGender()}>";
    }
}
