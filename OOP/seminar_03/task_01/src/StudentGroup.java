public class StudentGroup {
    private int number;
    protected StringBuilder students = new StringBuilder();

    public void addStudent(Student student) {
        students.append(student).append(" ");
    }
}
