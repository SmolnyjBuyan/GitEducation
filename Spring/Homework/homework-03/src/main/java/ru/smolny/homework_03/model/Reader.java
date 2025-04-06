package ru.smolny.homework_03.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "readers")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "names", nullable = false)
    private String name;

    @OneToMany(mappedBy = "reader")
    private List<Issue> issues;

    public List<Issue> getNotReturnedIssues() {
        return issues.stream().filter(Issue::isNotReturned).toList();
    }
}
