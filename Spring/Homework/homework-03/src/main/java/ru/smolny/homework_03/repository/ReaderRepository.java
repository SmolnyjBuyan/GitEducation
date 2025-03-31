package ru.smolny.homework_03.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.smolny.homework_03.exception.ReaderNotFoundException;
import ru.smolny.homework_03.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReaderRepository {
    private final List<Reader> readers;

    public ReaderRepository() {
        readers = new ArrayList<>();
    }

    @PostConstruct
    private void generateData() {
        readers.addAll(List.of(
                new Reader("Андрей"),
                new Reader("Дарья"),
                new Reader("Николай")
        ));
    }

    public Optional<Reader> getById(long id) {
        return readers.stream().filter(reader -> reader.getId() == id).findFirst();
    }

    public boolean deleteById(long id) {
        return readers.removeIf(reader -> reader.getId() == id);
    }

    public Reader create(String name) {
        Reader reader = new Reader(name);
        readers.add(reader);
        return reader;
    }
}
