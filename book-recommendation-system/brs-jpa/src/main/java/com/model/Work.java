package com.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Data
@Entity
@Table(name = "Work")
public class Work {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "workauthor",
            joinColumns = @JoinColumn(name = "workId"),
            inverseJoinColumns = @JoinColumn(name = "authorId")
    )
    private Set<Author> authors = new HashSet<>();

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "worksubject",
            joinColumns = @JoinColumn(name = "workId"),
            inverseJoinColumns = @JoinColumn(name = "subjectId")
    )
    private Set<Subject>  subjects = new HashSet<>();
}
