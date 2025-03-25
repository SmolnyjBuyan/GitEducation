package ru.smolny.seminar_02;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User("Andrey"));
        users.add(new User("Sergey"));
        users.add(new User("Egor"));
        users.add(new User("Oleg"));
    }

    public List<User> getAll() {
        return List.copyOf(users);
    }

    public User getById(long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User getByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }
}
