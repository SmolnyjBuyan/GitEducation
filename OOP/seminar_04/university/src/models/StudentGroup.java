package models;

import util.StudentGroupIterator;

import java.util.Iterator;
import java.util.List;

public class StudentGroup implements Iterable<Student>{

    private int number;
    private List<Student> students;

    public StudentGroup(int number) {
        this.number = number;
    }

    public StudentGroup(int number, List<Student> students) {
        this.number = number;
        this.students = students;
    }

    public int getNumber() {
        return number;
    }

    public List<Student> getStudents() {
        return students;
    }


    @Override
    public String toString() {
        return "StudentGroup=" + number + "{" +
                "students=" + students +
                '}';
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(this);
    }
}
