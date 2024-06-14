package view.impl;

import controller.impl.StudentController;
import model.impl.Student;
import view.UserView;

import java.util.Scanner;

public class StudentView extends UserView {
    private StudentController studentController = new StudentController();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Find Student");
            System.out.println("3. Show All Students");
            System.out.println("4. Go Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> create();
                case 2 -> getById();
                case 3 -> getAll();
                case 4 -> {
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
    private void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();

        System.out.println("Enter student last name: ");
        String lastName = scanner.nextLine();;

        Student student = studentController.create(name, lastName);
        System.out.println(student);
    }

    private void getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        Student student = studentController.getById(id);
        if (student != null) {
            System.out.println(student);
        }
    }

    private void getAll() {
        for (Student student : studentController.getAll()) {
            System.out.println(student);
        }
    }
}
