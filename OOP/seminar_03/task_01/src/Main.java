//Задача 1 - Iterator
//� Создать класс Студент
//� Создать класс УчебнаяГруппа
//� Создать класс УчебнаяГруппаИтератор, заставив его реализовать
//интерфейс Iterator
//� Реализовать его контракты (включая удаление)

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentGroup studentGroup = new StudentGroup();

        Student niko = new Student("Niko");
        Student tony = new Student("Tony");
        Student steve = new Student("Steve");
        Student ron = new Student("Ron");

        studentGroup.addStudent(niko);
        studentGroup.addStudent(tony);
        studentGroup.addStudent(steve);
        studentGroup.addStudent(ron);

        System.out.println(studentGroup.students);
        Iterator<Student> iterator = new StudentGroupIterator(studentGroup);


        System.out.println(studentGroup.students);

        List<Integer> students = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Iterator<Integer> iterator1 = students.iterator();

        while (iterator1.hasNext()) {
            if (iterator1.next() % 2 == 0) {
                iterator1.remove();
            }
        }

        System.out.println(students);

    }
}