package view.impl;

import controller.impl.TeacherController;
import model.impl.Teacher;
import view.UserView;

import java.util.Scanner;

public class TeacherView extends UserView {
    private TeacherController teacherController = new TeacherController();
    private String menu = "1. Add Teacher\n2. Find Teacher\n3. Show All Teachers\n4. Go Back";

    public void start() {
        super.start(menu);
    }

    @Override
    protected void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter teacher name: ");
        String name = scanner.nextLine();

        System.out.println("Enter teacher last name: ");
        String lastName = scanner.nextLine();

        Teacher teacher = teacherController.create(name, lastName);
        System.out.println(teacher);
    }

    @Override
    protected void getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter teacher id: ");
        int id = scanner.nextInt();
        Teacher teacher = teacherController.getById(id);
        if (teacher != null) {
            System.out.println(teacher);
        }
    }

    @Override
    protected void getAll() {
        for (Teacher teacher : teacherController.getAll()) {
            System.out.println(teacher);
        }
    }
}

