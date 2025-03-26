package ru.smolny.homework_02;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repository;

    @GetMapping("/student/{id}")
    public Student getById(@PathVariable long id) {
        return repository.getById(id);
    }

    @GetMapping("/student")
    public List<Student> getAll() {
        return repository.getAll();
    }

    @GetMapping("/student/search")
    public List<Student> getByName(@RequestParam String name) {
        return repository.getByName(name);
    }

    @GetMapping("/group/{groupName}/student")
    public List<Student> getByGroup(@PathVariable String groupName) {
        return repository.getByGroup(groupName);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return repository.add(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteByID(@PathVariable long id) {
        Student existsStudent = repository.getById(id);
        if (existsStudent == null) {
            return "Студента с id=" + id + " не существует";
        } else {
            repository.deleteById(id);
            return existsStudent.toString() + " успешно удален";
        }
    }
}
