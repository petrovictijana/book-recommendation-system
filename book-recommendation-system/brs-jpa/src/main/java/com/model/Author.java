package com.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Table(name = "Author")
public class Author {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "authors")
    private Set<Work> works = new HashSet<>();
}
