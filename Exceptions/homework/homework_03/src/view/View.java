package view;

import controller.PersonController;
import model.Person;
import util.GenderParseException;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class View {
    PersonController personController = new PersonController();

    public void start() {
        System.out.println("Ведите данные в следующем формате: Фамилия Имя Отчество датарождения номертелефона пол\n" +
                "Форматы данных:\n" +
                "фамилия, имя, отчество - строки\n" +
                "дата_рождения - строка формата dd.mm.yyyy\n" +
                "номер_телефона - целое беззнаковое число без форматирования\n" +
                "пол - символ латиницей f или m.\n");
        String data = prompt();
        String[] splitData = data.split(" ");
        switch (personController.checkDataSize(splitData)) {
            case 1 -> {
                System.err.println("Введено меньше данных, чем требуется");
                start();
            }
            case -1 -> {
                System.err.println("Введено больше данных, чем требуется");
                start();
            }
        }

        Person person = new Person();
        try {
            person = personController.createPerson(splitData);
        } catch (GenderParseException | DateTimeParseException | NumberFormatException e) {
            System.err.println(STR."\{e.getClass()}\n\{e.getMessage()}");
            start();
        }

        try {
            personController.printPerson(person);
        } catch (IOException e) {
            e.printStackTrace();
            start();
        }

        System.out.println("Продолжим? 1 - Да, 0 - Нет");
        if (prompt().equals("1")) {
            start();
        } else {
            System.exit(0);
        }
    }

    public String prompt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
