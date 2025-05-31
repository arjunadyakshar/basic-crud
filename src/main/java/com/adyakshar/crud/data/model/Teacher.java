package com.adyakshar.crud.data.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Teacher extends BaseEntity {

    private String name;
    private String subject;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}

