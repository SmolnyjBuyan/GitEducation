package services;

import models.Student;
import models.User;
import view.StudentView;
import util.UserComparator;
import models.StudentGroup;

import java.util.Collections;
import java.util.Iterator;

public class StudentGroupService{
    private StudentGroup studentGroup;

    public StudentGroupService(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public void addStudent(Student student){
        studentGroup.getStudents().add(student);
    }

    public void removeStudent(String lastName, String firstName, String surname) {
        Iterator<Student> iterator = studentGroup.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getFirstname().equals(firstName)
                && student.getLastname().equals(lastName)
                && student.getSurname().equals(surname)) {
                iterator.remove();
            }
        }
    }

    public void sortStudentsById() {
        Collections.sort(studentGroup.getStudents());
    }

    public void sortStudentsByName() {
        UserComparator<User> comparator = new UserComparator<>();
        Collections.sort(studentGroup.getStudents(), comparator.reversed());
    }
}
