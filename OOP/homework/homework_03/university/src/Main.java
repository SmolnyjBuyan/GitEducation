import students.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student first = new Student("Котов", "Андрей", "Андреевич", 3);
        Student second = new Student("Кожевин", "Сергей", "Михайлович",4);
        Student third = new Student("Столяренко", "Дмитрий", "Александрович", 2);
        Student fourth = new Student("Митинский", "Василий", "Васильевич", 1);

        List<Student> fg = new ArrayList<>(List.of(first, second, third, fourth));
        StudentGroup firstGroup = new StudentGroup(1, fg);

        Iterator<Student> iterator = new StudentGroupIterator(firstGroup);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();


        while (iterator.hasNext()) {
            if (iterator.next().getLastname().charAt(0) == 'К') {
                iterator.remove();
            }
        }

        System.out.println(firstGroup);

        System.out.println("\nTask_2\n");

        for (Student student : firstGroup) {
            System.out.println(student);
        }

        System.out.println("\nСоздать класс УчебнаяГруппаСервис, добавив в него метод удаления студента по ФИО\n");

        StudentGroupService service = new StudentGroupService(firstGroup);
        service.removeStudent("Столяренко", "Дмитрий", "Александрович");

        System.out.println(firstGroup);
        firstGroup.addStudent(first);
        firstGroup.addStudent(second);
        firstGroup.addStudent(third);

        System.out.println("\nМодифицировать класс УчебнаяГруппаСервис, добавив в него метод сортировки списка студентов по id\n");
        System.out.println(firstGroup);
        service.sortStudentsById();
        System.out.println(firstGroup);

        System.out.println("\nРеализовать контракт compare () со сравнением по какому-либо параметру (пример: сочетание Имя+Фамилия)\n");
        System.out.println(firstGroup);
        service.sortStudentsByName();
        System.out.println(firstGroup);

    }
}