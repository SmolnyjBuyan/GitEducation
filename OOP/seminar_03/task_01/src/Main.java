//Задача 1 - Iterator
//� Создать класс Студент
//� Создать класс УчебнаяГруппа
//� Создать класс УчебнаяГруппаИтератор, заставив его реализовать
//интерфейс Iterator
//� Реализовать его контракты (включая удаление)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentGroup studentGroup = new StudentGroup();

        Student niko = new Student("Niko", 4);
        Student tony = new Student("Tony", 1);
        Student steve = new Student("Steve", 2);
        Student ron = new Student("Ron", 3);

        studentGroup.addStudent(niko);
        studentGroup.addStudent(tony);
        studentGroup.addStudent(steve);
        studentGroup.addStudent(ron);

        System.out.println(studentGroup.students);
        Iterator<Student> iterator = new StudentGroupIterator(studentGroup);

        for (Student student : studentGroup) {
            System.out.println(student);
        }

        ArrayList<Student> arrayList = new ArrayList<>(List.of(niko, tony, steve,ron));
        System.out.println(arrayList);
        Collections.sort(arrayList, (s1, s2) -> s1.id - s2.id);
        System.out.println(arrayList);
    }
}