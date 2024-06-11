import controllers.StreamController;
import controllers.StudentController;
import controllers.StudentGroupController;
import models.Student;
import models.StudentGroup;
import util.StudentGroupIterator;
import models.Stream;
import util.StreamComparator;
import services.StreamService;
import services.StudentGroupService;
import view.StudentView;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student first = new Student("Котов", "Андрей", "Андреевич", 3);
        Student second = new Student("Кожевин", "Сергей", "Михайлович",4);
        Student third = new Student("Столяренко", "Дмитрий", "Александрович", 2);
        Student fourth = new Student("Митинский", "Василий", "Васильевич", 1);

        List<Student> fg = new ArrayList<>(List.of(first, second, third, fourth));
        StudentGroup firstGroup = new StudentGroup(1, fg);

        System.out.println("\nfor (Student student : firstGroup)\n");

        for (Student student : firstGroup) {
            System.out.println(student);
        }

        StudentGroupService firstGroupStudentGroupService = new StudentGroupService(firstGroup);
        StudentGroupController firstGroupStudentGroupController = new StudentGroupController(firstGroupStudentGroupService);

        System.out.println("\nStudentView\n");
        StudentController studentController = new StudentController();
        studentController.sendOnConsole(List.of(first, second, third));
    }
}