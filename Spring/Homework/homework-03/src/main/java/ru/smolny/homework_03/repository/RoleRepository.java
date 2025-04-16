package ru.smolny.homework_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smolny.homework_03.model.Role;
import ru.smolny.homework_03.model.RoleType;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
