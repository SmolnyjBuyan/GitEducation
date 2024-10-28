package controller;

import model.Person;
import util.Gender;
import util.GenderParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class PersonController {
    public Person createPerson(String[] data) throws GenderParseException {
        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];

        LocalDate birthdate = null;
        try {
            birthdate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Неверный формат даты", e.getParsedString(), e.getErrorIndex());
        }

        long phoneNumber = 0;
        try {
            phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат номера телефона");
        }

        Gender gender;
        if (Objects.equals(data[5], "f")) {
            gender = Gender.FEMALE;
        } else if (Objects.equals(data[5], "m")) {
            gender = Gender.MALE;
        } else {
            throw new GenderParseException("Неверный формат пола");
        }

        return new Person(lastName, firstName, middleName, phoneNumber, gender, birthdate);
    }

    public int checkDataSize(String[] data) {
        return Integer.compare(Person.fieldsCount, data.length);
    }

    public void printPerson(Person person) throws IOException {
        try (FileWriter fileWriter = new FileWriter(STR."\{person.getLastName()}.txt", true)) {
            fileWriter.write(STR."\{String.valueOf(person)}\n");
            System.out.println("Информация успешно записана в файл");
        }
    }
}
