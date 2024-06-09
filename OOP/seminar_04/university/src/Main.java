import controllers.StreamController;
import controllers.StudentGroupController;
import models.Student;
import models.StudentGroup;
import models.StudentGroupIterator;
import models.Stream;
import models.StreamComparator;
import services.StreamService;
import services.StudentGroupService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student first = new Student("Котов", "Андрей", "Андреевич", 3);
        Student second = new Student("Кожевин", "Сергей", "Михайлович",4);
        Student third = new Student("Столяренко", "Дмитрий", "Александрович", 2);
        Student fourth = new Student("Митинский", "Василий", "Васильевич", 1);

        List<Student> fg = new ArrayList<>(List.of(first, second, third, fourth));
        StudentGroup firstGroup = new StudentGroup(1, fg);

        System.out.println("\nIterator<Student> iterator\n");

        Iterator<Student> iterator = new StudentGroupIterator(firstGroup);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        System.out.println("\niterator.remove() charAt(0) == 'К'\n");

        while (iterator.hasNext()) {
            if (iterator.next().getLastname().charAt(0) == 'К') {
                iterator.remove();
            }
        }

        System.out.println(firstGroup);

        System.out.println("\nfor (Student student : firstGroup)\n");

        for (Student student : firstGroup) {
            System.out.println(student);
        }

        System.out.println("\ncontroller.removeStudent\n");

        StudentGroupService firstGroupStudentGroupService = new StudentGroupService(firstGroup);
        StudentGroupController firstGroupStudentGroupController = new StudentGroupController(firstGroupStudentGroupService);
        firstGroupStudentGroupController.removeStudent("Столяренко", "Дмитрий", "Александрович");
        System.out.println(firstGroup);

        System.out.println("\nВернем студентов обратно\n");
        firstGroupStudentGroupController.addStudent(first);
        firstGroupStudentGroupController.addStudent(second);
        firstGroupStudentGroupController.addStudent(third);
        System.out.println(firstGroup);

        System.out.println("\ncontroller.sortStudentsById(firstGroup)\n");
        System.out.println(firstGroup);
        firstGroupStudentGroupController.sortStudentsById(firstGroup);
        System.out.println(firstGroup);

        System.out.println("\ncontroller.sortStudentsByName(firstGroup);\n");
        System.out.println(firstGroup);
        firstGroupStudentGroupController.sortStudentsByName(firstGroup);
        System.out.println(firstGroup);

        System.out.println("\nСоздадим потоки и добавим в них группы\n");

        Student fifth = new Student("Могутова", "Елена", "Николаевна", 5);
        Student sixth = new Student("Лисицына", "Светлана", "Николаевна", 6);
        Student seventh = new Student("Косенко", "Софья", "Алексеевна", 7);
//
        List<Student> sg = new ArrayList<>(List.of(fifth, sixth, seventh));
        StudentGroup secondGroup = new StudentGroup(2, sg);
        StudentGroup thirdGroup = new StudentGroup(3);
        StudentGroup fourthGroup = new StudentGroup(4);
        StudentGroup fifthGroup = new StudentGroup(5);
        StudentGroup sixthGroup = new StudentGroup(6);
        StudentGroup seventhGroup = new StudentGroup(7);
        StudentGroup eighth = new StudentGroup(8);
        StudentGroup ninth = new StudentGroup(9);

        Stream firstStream = new Stream(100);
        StreamService firstStreamService = new StreamService(firstStream);
        StreamController firstStreamController = new StreamController(firstStreamService);

        firstStreamController.addStudentGroup(firstGroup);
        firstStreamController.addStudentGroup(secondGroup);
        firstStreamController.addStudentGroup(thirdGroup);

        Stream secondStream = new Stream(200);
        StreamService secondStreamService = new StreamService(secondStream);
        StreamController secondStreamController = new StreamController(secondStreamService);

        secondStreamController.addStudentGroup(fourthGroup);
        secondStreamController.addStudentGroup(fifthGroup);

        Stream thirdStream = new Stream(300);
        StreamService thirdStreamService = new StreamService(thirdStream);
        StreamController thirdStreamController = new StreamController(thirdStreamService);

        thirdStreamController.addStudentGroup(sixthGroup);
        thirdStreamController.addStudentGroup(seventhGroup);
        thirdStreamController.addStudentGroup(eighth);
        thirdStreamController.addStudentGroup(ninth);


        System.out.println(firstStream + "\n" + secondStream + "\n" + thirdStream + "\n");

        System.out.println("\nstreams.sort(new StreamComparator())\n");

        List<Stream> streams = new ArrayList<>(List.of(firstStream, secondStream, thirdStream));
        System.out.println(streams);

        streams.sort(new StreamComparator());
        System.out.println(streams.reversed());

        System.out.println("\ncontroller.sortStreamsByGroupCount(streams)\n");

        thirdStreamController.sortStreamsByGroupCount(streams);
        System.out.println(streams);
    }
}