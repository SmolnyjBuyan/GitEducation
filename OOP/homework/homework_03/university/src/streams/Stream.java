package streams;

import students.StudentGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<StudentGroup>{
    private int number;
    private List<StudentGroup> studentGroupList = new ArrayList<>();

    public Stream(int number) {
        this.number = number;
    }

    public void addStudentGroup(StudentGroup studentGroup) {
        studentGroupList.add(studentGroup);
    }

    public List<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new Iterator<>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < studentGroupList.size();
            }

            @Override
            public StudentGroup next() {
                return studentGroupList.get(index++);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Stream=" + number +"{");

        for (StudentGroup studentGroup : studentGroupList) {
            result.append("groupNumber: ").append(studentGroup.getNumber()).append(";");
        }

        result.append("}");
        return result.toString();
    }
}
