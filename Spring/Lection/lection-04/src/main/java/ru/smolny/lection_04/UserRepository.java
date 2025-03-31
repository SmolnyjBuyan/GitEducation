package ru.smolny.lection_04;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

    @PostConstruct
    private void generateData() {
        save(new User("Anton", "anton@sm.ru"));
        save(new User("Bogdan", "bogdan@sm.ru"));
        save(new User("Lukas", "lukas@sm.ru"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User findById(Long id) {
        return users.get(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        users.put(user.getId(), user);
        return user;
    }
}
