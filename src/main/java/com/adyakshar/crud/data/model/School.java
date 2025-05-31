package com.adyakshar.crud.data.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "schools")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class School extends BaseEntity {

    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Student> students;
}
