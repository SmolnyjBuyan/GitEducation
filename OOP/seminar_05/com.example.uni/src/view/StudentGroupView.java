package view;

import controller.StudentGroupController;
import controller.impl.StudentController;
import model.StudentGroup;
import model.db.DataBase;
import model.impl.Student;
import model.impl.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGroupView {

    StudentGroupController studentGroupController = new StudentGroupController();
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student Group");
            System.out.println("2. Find Student Group");
            System.out.println("4. Go Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createStudentGroup();
                case 2 -> getStudentGroupByNumber();
                case 4 -> {
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void createStudentGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter group number: ");
        int number = scanner.nextInt();

        System.out.println(DataBase.teachersDB);
        System.out.println("Enter teacher id: ");
        int teacherId = scanner.nextInt();

        List<Student> studentList = new ArrayList<>();
        System.out.println(DataBase.studentsDB);

        while (true) {
            System.out.println("Enter student id or enter '0' if that's enough: ");
            int studentId = scanner.nextInt();
            if (studentId == 0) {
                break;
            } else {
                studentList.add(DataBase.studentsDB.get(studentId));
            }
        }

        studentGroupController.createStudentGroup(number, DataBase.teachersDB.get(teacherId - 1), studentList);
    }

    private void getStudentGroupByNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter group number: ");
        int number = scanner.nextInt();
        System.out.println(DataBase.studentGroupsDB.stream()
                .filter(sg -> sg.getNumber()==number)
                .findFirst()
                .orElse(null));

    }
}
