import javax.annotation.processing.Completion;
import java.util.Objects;

public class Student  implements Comparable<Student> {

    private String name;
    public int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;

    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }


    @Override
    public int compareTo(Student o) {
        return o.name.length() - this.name.length();
//        if (o.name.length() > this.name.length()) return -1;
//        else if (o.name.length() < this.name.length()) return 1;
//        else return 0;
    }
}
