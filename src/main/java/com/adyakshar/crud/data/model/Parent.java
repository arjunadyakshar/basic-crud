package com.adyakshar.crud.data.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "parents")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Parent extends BaseEntity {

    private String name;
    private String email;
    private Integer age;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Student> children;
}

