package com.adyakshar.crud.web.mapper;

import com.adyakshar.crud.data.model.Parent;
import com.adyakshar.crud.data.model.School;
import com.adyakshar.crud.data.model.Student;
import com.adyakshar.crud.web.dto.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper extends BaseEntityMapper<Student, StudentDTO> {

    public StudentDTO toDto(Student entity) {
        if (entity == null) {
            return null;
        }

        StudentDTO dto = new StudentDTO();
        mapToDto(entity, dto);
        
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        
        if (entity.getParent() != null) {
            dto.setParentId(entity.getParent().getId());
        }
        
        if (entity.getSchool() != null) {
            dto.setSchoolId(entity.getSchool().getId());
        }
        
        return dto;
    }
    
    public List<StudentDTO> toDtoList(List<Student> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        
        return entities.stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }
    
    public Student toEntity(StudentDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Student entity = new Student();
        mapToEntity(dto, entity);
        
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        
        if (dto.getParentId() != null) {
            Parent parent = new Parent();
            parent.setId(dto.getParentId());
            entity.setParent(parent);
        }
        
        if (dto.getSchoolId() != null) {
            School school = new School();
            school.setId(dto.getSchoolId());
            entity.setSchool(school);
        }
        
        return entity;
    }
    
    public Student updateEntity(StudentDTO dto, Student entity) {
        if (dto == null || entity == null) {
            return entity;
        }
        
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getAge() != null) entity.setAge(dto.getAge());
        if (dto.getAddress() != null) entity.setAddress(dto.getAddress());
        if (dto.getPhoneNumber() != null) entity.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        
        if (dto.getParentId() != null) {
            Parent parent = new Parent();
            parent.setId(dto.getParentId());
            entity.setParent(parent);
        }
        
        if (dto.getSchoolId() != null) {
            School school = new School();
            school.setId(dto.getSchoolId());
            entity.setSchool(school);
        }
        
        return entity;
    }
}