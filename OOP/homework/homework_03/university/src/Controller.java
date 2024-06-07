import students.StudentGroupService;

public class Controller {
    StudentGroupService studentGroupService;

    public void removeStudent(String lastname, String firstname, String surname) {
        studentGroupService.removeStudent(lastname, firstname, surname);
    }

    public void sortStudentsById() {
        studentGroupService.sortStudentsById();
    }

    public void sortStudentsByName() {
        studentGroupService.sortStudentsByName();
    }
}
