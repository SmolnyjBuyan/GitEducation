package view.impl;

import controller.impl.StudentController;
import model.impl.Student;
import view.UserView;

import java.util.Scanner;

public class StudentView extends UserView {
    private StudentController studentController = new StudentController();
    private String menu = "1. Add Student\n2. Find Student\n3. Show All Student\n4. Go Back";

    public void start() {
        super.start(menu);
    }
    protected void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();

        System.out.println("Enter student last name: ");
        String lastName = scanner.nextLine();

        Student student = studentController.create(name, lastName);
        System.out.println(student);
    }

    protected void getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        Student student = studentController.getById(id);
        if (student != null) {
            System.out.println(student);
        }
    }

    protected void getAll() {
        for (Student student : studentController.getAll()) {
            System.out.println(student);
        }
    }
}
