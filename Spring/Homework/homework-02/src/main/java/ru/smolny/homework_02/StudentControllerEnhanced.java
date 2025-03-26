package ru.smolny.homework_02;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentControllerEnhanced {
    private final StudentRepository repository;

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getById(@PathVariable long id) {
        Student student = repository.getById(id);
        if (student == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(repository.getAll());
    }

    @GetMapping("/student/search")
    public ResponseEntity<List<Student>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(repository.getByName(name));
    }

    @GetMapping("/group/{groupName}/student")
    public ResponseEntity<List<Student>> getByGroup(@PathVariable String groupName) {
        List<Student> studentsOfGroup = repository.getByGroup(groupName);
        if (studentsOfGroup == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentsOfGroup);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(repository.add(student));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable long id) {
        if (repository.getById(id) == null) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
