package ru.smolny.homework_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smolny.homework_03.model.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    boolean existsByNameIgnoreCase(String name);
}
