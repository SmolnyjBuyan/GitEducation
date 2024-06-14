package view;

import controller.StudentGroupController;
import controller.impl.StudentController;
import controller.impl.TeacherController;
import model.StudentGroup;
import model.impl.Student;
import model.impl.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGroupView {
    StudentGroupController studentGroupController = new StudentGroupController();
    StudentController studentController = new StudentController();
    TeacherController teacherController = new TeacherController();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student Group");
            System.out.println("2. Find Student Group");
            System.out.println("3. Show All Student Groups");
            System.out.println("4. Go Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createStudentGroup();
                case 2 -> getStudentGroupByNumber();
                case 3 -> showAllStudentGroups();
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
        if (studentGroupController.checkStudentGroup(number)) {
            System.out.println("Student group already exists");
        } else {
            for (Teacher teacher : teacherController.getAll()) {
                System.out.println(teacher);
            }
            System.out.println("Enter teacher id: ");
            int teacherId = scanner.nextInt();

            List<Student> studentList = new ArrayList<>();
            for (Student student : studentController.getAll()) {
                System.out.println(student);
            }

            while (true) {
                System.out.println("Enter student id or enter '0' if that's enough: ");
                int studentId = scanner.nextInt();
                if (studentId == 0) {
                    break;
                } else {
                    studentList.add(studentController.getById(studentId));
                }
            }

            System.out.println(studentGroupController.createStudentGroup(number, teacherController.getById(teacherId), studentList));
        }
    }

    private void getStudentGroupByNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter group number: ");
        int number = scanner.nextInt();

        StudentGroup studentGroup = studentGroupController.getStudentGroupById(number);
        if (studentGroup != null) {
            System.out.println(studentGroup);
        }
    }

    private void showAllStudentGroups() {
        studentGroupController.getAllStudentGroups();
    }
}
