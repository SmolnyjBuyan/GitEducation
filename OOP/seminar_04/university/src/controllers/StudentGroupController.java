package controllers;

import models.Student;
import models.StudentGroup;
import services.StudentGroupService;

public class StudentGroupController {
    private StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    public void addStudent(Student student){
        studentGroupService.addStudent(student);
    }

    public void removeStudent(String lastname, String firstname, String surname) {
        studentGroupService.removeStudent(lastname, firstname, surname);
    }

    public void sortStudentsById(StudentGroup studentGroup) {
        studentGroupService.sortStudentsById();
    }

    public void sortStudentsByName(StudentGroup studentGroup) {
        studentGroupService.sortStudentsByName();
    }

    public void sendOnConsole(){
        studentGroupService.sendOnConsole();
    }
}
