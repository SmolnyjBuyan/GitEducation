package view;

import controller.StudentController;
import model.db.DataBase;
import model.impl.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private StudentController studentController = new StudentController();

    public void start() {
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Find Student");
            System.out.println("3. Show All Students");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createStudent();
                case 2 -> getStudentById();
                case 3 -> getAllStudents();
                case 4 -> System.exit(0);

                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();

        System.out.println("Enter student last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter group number: ");
        int groupId = scanner.nextInt();

        Student student = studentController.createStudent(name, lastName, groupId);
        System.out.println(student);
    }

    private void getStudentById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        System.out.println(studentController.getStudentById(id));
    }

    private void getAllStudents() {
        System.out.println(studentController.getAllStudents());
    }
}
