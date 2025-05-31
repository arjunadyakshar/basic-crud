package com.adyakshar.crud.data.model;

import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@SuperBuilder
public class Student extends BaseEntity {

    private String name;
    private Integer age;
    private String address;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}

