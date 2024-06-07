package students;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class StudentGroupService {
    StudentGroup studentGroup;

    public StudentGroupService(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
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
        StudentComparator comparator = new StudentComparator();
        Collections.sort(studentGroup.getStudents(), comparator.reversed());
    }
}
