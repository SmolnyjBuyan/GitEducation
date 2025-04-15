package ru.smolny.homework_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smolny.homework_03.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByNameIgnoreCase(String name);
}
