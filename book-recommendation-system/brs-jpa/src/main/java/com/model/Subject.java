package com.model;

import com.enums.SubjectCategory;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Table(name = "Subject")
public class Subject {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private SubjectCategory category;

    @Builder.Default
    @ManyToMany(mappedBy = "subjects")
    private Set<Work> works = new HashSet<>();
}
