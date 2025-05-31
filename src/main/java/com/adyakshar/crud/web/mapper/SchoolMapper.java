package com.adyakshar.crud.web.mapper;

import com.adyakshar.crud.data.model.School;
import com.adyakshar.crud.data.model.Student;
import com.adyakshar.crud.data.model.Teacher;
import com.adyakshar.crud.web.dto.SchoolDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SchoolMapper extends BaseEntityMapper<School, SchoolDTO> {

    public SchoolDTO toDto(School entity) {
        if (entity == null) {
            return null;
        }

        SchoolDTO dto = new SchoolDTO();
        mapToDto(entity, dto);
        
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        
        if (entity.getTeachers() != null) {
            dto.setTeacherIds(entity.getTeachers().stream()
                .map(Teacher::getId)
                .collect(Collectors.toList()));
        } else {
            dto.setTeacherIds(Collections.emptyList());
        }
        
        if (entity.getStudents() != null) {
            dto.setStudentIds(entity.getStudents().stream()
                .map(Student::getId)
                .collect(Collectors.toList()));
        } else {
            dto.setStudentIds(Collections.emptyList());
        }
        
        return dto;
    }
    
    public List<SchoolDTO> toDtoList(List<School> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        
        return entities.stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }
    
    public School toEntity(SchoolDTO dto) {
        if (dto == null) {
            return null;
        }
        
        School entity = new School();
        mapToEntity(dto, entity);
        
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        
        // We don't set the collections here to avoid circular references
        // That would typically be handled by the service layer
        
        return entity;
    }
    
    public School updateEntity(SchoolDTO dto, School entity) {
        if (dto == null || entity == null) {
            return entity;
        }
        
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getAddress() != null) entity.setAddress(dto.getAddress());
        if (dto.getPhoneNumber() != null) entity.setPhoneNumber(dto.getPhoneNumber());
        
        return entity;
    }
}