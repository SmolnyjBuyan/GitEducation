package students;

import java.util.Iterator;
import java.util.List;

public class StudentGroup implements Iterable<Student>{

    private int number;
    private List<Student> students;

    public StudentGroup(int number, List<Student> students) {
        this.number = number;
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public int getNumber() {
        return number;
    }

    public List<Student> getStudents() {
        return students;
    }


    @Override
    public String toString() {
        return "StudentGroup{" +
                "students=" + students +
                '}';
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(this);
    }
}
