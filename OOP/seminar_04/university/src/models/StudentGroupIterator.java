package models;

import java.util.Iterator;

public class StudentGroupIterator implements Iterator<Student> {
    private int index;
    StudentGroup studentGroup;

    public StudentGroupIterator(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public boolean hasNext() {
        if (index < studentGroup.getStudents().size()) {
            return true;
        } else {
            index = 0;
            return false;
        }
    }

    @Override
    public Student next() {
        return studentGroup.getStudents().get(index++);
    }

    @Override
    public void remove() {
        studentGroup.getStudents().remove(index - 1);
        index--;
    }
}
