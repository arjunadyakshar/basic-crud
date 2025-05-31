package com.adyakshar.crud.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO extends BaseEntityDTO {
    private String name;
    private Integer age;
    private String address;
    private String phoneNumber;
    private String email;
    private Long parentId; // Just store the parent ID
    private Long schoolId; // Just store the school ID
}