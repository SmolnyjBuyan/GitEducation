package ru.smolny.homework_03.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.smolny.homework_03.model.Reader;

import java.util.ArrayList;
import java.util.List;

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

    public Reader getReaderById(long id) {
        return readers.stream().filter(reader -> reader.getId() == id).findFirst().orElse(null);
    }
}
