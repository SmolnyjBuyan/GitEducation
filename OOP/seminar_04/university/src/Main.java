import controllers.StreamController;
import controllers.StudentController;
import controllers.StudentGroupController;
import controllers.TeacherController;
import models.Student;
import models.StudentGroup;
import models.Teacher;
import services.TeacherService;
import util.StudentGroupIterator;
import models.Stream;
import util.StreamComparator;
import services.StreamService;
import services.StudentGroupService;
import view.StudentView;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        StudentController studentController = new StudentController();

        Student first = studentController.create("Котов", "Андрей", "Андреевич");
        Student second = studentController.create("Кожевин", "Сергей", "Михайлович");
        Student third = studentController.create("Столяренко", "Дмитрий", "Александрович");
        Student fourth = studentController.create("Митинский", "Василий", "Васильевич");

        System.out.println("\nStudentView\n");
        studentController.sendOnConsole(List.of(first, second, third, fourth));

        System.out.println("\nTeacher\n");

        TeacherController teacherController = new TeacherController();
        Teacher nadezhda = teacherController.create("Довбыш", "Надежда", "Ивановна");
        System.out.println(nadezhda);

        System.out.println("\nTeacherService.editTeacher()\n");
        teacherController.editTeacher(nadezhda, "Довбыш", "Надежда", "Петровна");
        System.out.println(nadezhda);


        System.out.println("\nTeacherService.sendOnConsole()\n");
        Teacher tamara = teacherController.create("Дуркина", "Тамара", "Федоровна");
        Teacher mihail = teacherController.create("Веретнов", "Михаил", "Юрьевич");
        teacherController.sendOnConsole(Teacher.getTeacherList());

    }
}