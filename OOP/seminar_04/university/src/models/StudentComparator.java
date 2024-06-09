package models;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int firstLength = (o1.getFirstname() + o1.getLastname()).length();
        int secondLength = (o2.getFirstname() + o2.getLastname()).length();
        return firstLength - secondLength;
    }
}
