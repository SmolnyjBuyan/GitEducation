import students.Student;
import students.StudentGroup;
import students.StudentGroupIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student first = new Student("Котов", "Андрей", "Андреевич");
        Student second = new Student("Кожевин", "Сергей", "Михайлович");
        Student third = new Student("Столяренко", "Дмитрий", "Александрович");
        Student fourth = new Student("Митинский", "Василий", "Васильевич");

        List<Student> fg = new ArrayList<>(List.of(first, second, third, fourth));
        StudentGroup firstGroup = new StudentGroup(1, fg);

        Iterator<Student> iterator = new StudentGroupIterator(firstGroup);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();


        while (iterator.hasNext()) {
            if (iterator.next().toString().charAt(0) == 'К') {
                iterator.remove();
            }
        }

        System.out.println(firstGroup);

        System.out.println("\nTask_2\n");

        for (Student student : firstGroup) {
            System.out.println(student);
        }


    }
}