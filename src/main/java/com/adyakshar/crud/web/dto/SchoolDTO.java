package com.adyakshar.crud.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDTO extends BaseEntityDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Long> teacherIds; // Store only IDs to avoid circular references
    private List<Long> studentIds; // Store only IDs to avoid circular references
}