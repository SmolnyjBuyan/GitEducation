package view;

import model.db.DataBase;
import view.impl.StudentView;
import view.impl.TeacherView;

import java.util.Scanner;

public class MenuView {
    public void start() {
        DataBase.fillDB();
        StudentView studentView = new StudentView();
        TeacherView teacherView = new TeacherView();
        StudentGroupView studentGroupView = new StudentGroupView();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Students");
            System.out.println("2. Teachers");
            System.out.println("3. Student Groups");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> studentView.start();
                case 2 -> teacherView.start();
                case 3 -> studentGroupView.start();
                case 4 -> System.exit(0);

                default -> System.out.println("Invalid choice");
            }
        }
    }
}
