import streams.Stream;
import streams.StreamService;
import students.StudentGroup;
import students.StudentGroupService;

import java.util.List;

public class Controller {
    StudentGroupService studentGroupService = new StudentGroupService();
    StreamService streamService = new StreamService();

    public void removeStudent(StudentGroup studentGroup, String lastname, String firstname, String surname) {
        studentGroupService.removeStudent(studentGroup, lastname, firstname, surname);
    }

    public void sortStudentsById(StudentGroup studentGroup) {
        studentGroupService.sortStudentsById(studentGroup);
    }

    public void sortStudentsByName(StudentGroup studentGroup) {
        studentGroupService.sortStudentsByName(studentGroup);
    }

    public void sortStreamsByGroupCount(List<Stream> stream) {
        streamService.sortStreams(stream);
    }
}
