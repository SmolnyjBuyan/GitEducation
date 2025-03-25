package ru.smolny.seminar_02;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository repository;

//    @Autowired
//    public UserController(UserRepository repository) {
//        this.repository = repository;
//    }

    @GetMapping(path = "/all")
    public List<User> getUsers() {
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return repository.getById(id);
    }

    @GetMapping
    public User getUserByName(@RequestParam String name) {
        return repository.getByName(name);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        User existsUser = repository.getById(id);
        if (existsUser == null) {
            throw  new IllegalArgumentException();
        }
        existsUser.setName(user.getName());
        return existsUser;
    }
}
