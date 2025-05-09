package ru.smolny.homework_03.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, length = 64)
    private String title;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Issue> issues;

    public boolean isAvailable() {
        return issues.stream().noneMatch(Issue::isNotReturned);
    }
}
