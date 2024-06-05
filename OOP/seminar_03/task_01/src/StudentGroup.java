import java.util.Iterator;

public class StudentGroup implements Iterable<Student>{
    private int number;
    protected StringBuilder students = new StringBuilder();

    public void addStudent(Student student) {
        students.append(student).append(" ");
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(this);
    }
}
