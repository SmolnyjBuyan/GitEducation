package students;

import java.util.Collections;
import java.util.Iterator;

public class StudentGroupService {

    public void removeStudent(StudentGroup studentGroup, String lastName, String firstName, String surname) {
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

    public void sortStudentsById(StudentGroup studentGroup) {
        Collections.sort(studentGroup.getStudents());
    }

    public void sortStudentsByName(StudentGroup studentGroup) {
        StudentComparator comparator = new StudentComparator();
        Collections.sort(studentGroup.getStudents(), comparator.reversed());
    }
}
