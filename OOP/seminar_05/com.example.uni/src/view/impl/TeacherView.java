package view.impl;

import controller.impl.TeacherController;
import model.impl.Student;
import model.impl.Teacher;
import view.UserView;

import java.util.Scanner;

public class TeacherView extends UserView {
    private TeacherController teacherController = new TeacherController();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Teacher");
            System.out.println("2. Find Teacher");
            System.out.println("3. Show All Teachers");
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
        System.out.println("Enter teacher name: ");
        String name = scanner.nextLine();

        System.out.println("Enter teacher last name: ");
        String lastName = scanner.nextLine();;

        Teacher teacher = teacherController.create(name, lastName);
        System.out.println(teacher);
    }

    private void getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter teacher id: ");
        int id = scanner.nextInt();
        Teacher teacher = teacherController.getById(id);
        if (teacher != null) {
            System.out.println(teacher);
        }
    }

    private void getAll() {
        for (Teacher teacher : teacherController.getAll()) {
            System.out.println(teacher);
        }
    }
}
