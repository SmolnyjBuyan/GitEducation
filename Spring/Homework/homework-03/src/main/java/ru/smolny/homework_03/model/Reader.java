package ru.smolny.homework_03.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Entity
@Table(name = "readers")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Reader {
    @Value("${application.issue.max-allowed-books:1}")
    private int maxAllowedBooks;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "names", nullable = false)
    private String name;

    @OneToMany(mappedBy = "reader")
    @JsonIgnore
    private List<Issue> issues;

    @JsonIgnore
    public boolean isMaxBooksOnHand() {
        return issues.stream().filter(Issue::isNotReturned).count() >= 3;
    }

    @JsonIgnore
    public List<Issue> getNotReturnedIssues() {
        return issues.stream().filter(Issue::isNotReturned).toList();
    }
}
