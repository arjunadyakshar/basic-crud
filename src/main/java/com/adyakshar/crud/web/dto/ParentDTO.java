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
public class ParentDTO extends BaseEntityDTO {
    private String name;
    private String email;
    private Integer age;
    private String address;
    private String phoneNumber;
    private List<Long> childrenIds; // Store only IDs to avoid circular references
}