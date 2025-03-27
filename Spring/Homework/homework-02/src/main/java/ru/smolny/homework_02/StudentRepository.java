package ru.smolny.homework_02;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>(List.of(
                new Student("Andrey", "First"),
                new Student("Sergey", "Second"),
                new Student("Anton", "Third"),
                new Student("Masha", "Second"),
                new Student("Fedor", "First"),
                new Student("Nikolay", "Second"),
                new Student("Dmitriy", "Third"),
                new Student("Andrey", "Second"),
                new Student("Igor", "First"),
                new Student("Elena", "Second")
        ));
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public Student getById(long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public List<Student> getByName(String name) {
        return students.stream().filter(student -> student.getName()
                .toLowerCase().contains(name.toLowerCase())).toList();
    }

    public List<Student> getByGroup(String groupName) {
        List<Student> group = students.stream().filter(student -> student.getGroupName().equals(groupName)).toList();
        if (group.isEmpty()) return null;
        return group;
    }

    public Student add(Student student) {
        students.add(student);
        return student;
    }

    public boolean deleteById(long id) {
        return students.removeIf(student -> student.getId() == id);
    }
}
