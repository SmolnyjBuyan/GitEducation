package ru.smolny.homework_03.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "readers")
@Data
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "names", nullable = false)
    private final String name;

    @OneToMany(mappedBy = "reader")
    @JsonIgnore
    private List<Issue> issues;
}
