package com.adyakshar.crud.web.mapper;

import com.adyakshar.crud.data.model.School;
import com.adyakshar.crud.data.model.Teacher;
import com.adyakshar.crud.web.dto.TeacherDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherMapper extends BaseEntityMapper<Teacher, TeacherDTO> {

    public TeacherDTO toDto(Teacher entity) {
        if (entity == null) {
            return null;
        }

        TeacherDTO dto = new TeacherDTO();
        mapToDto(entity, dto);
        
        dto.setName(entity.getName());
        dto.setSubject(entity.getSubject());
        
        if (entity.getSchool() != null) {
            dto.setSchoolId(entity.getSchool().getId());
        }
        
        return dto;
    }
    
    public List<TeacherDTO> toDtoList(List<Teacher> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        
        return entities.stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }
    
    public Teacher toEntity(TeacherDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Teacher entity = new Teacher();
        mapToEntity(dto, entity);
        
        entity.setName(dto.getName());
        entity.setSubject(dto.getSubject());
        
        if (dto.getSchoolId() != null) {
            School school = new School();
            school.setId(dto.getSchoolId());
            entity.setSchool(school);
        }
        
        return entity;
    }
    
    public Teacher updateEntity(TeacherDTO dto, Teacher entity) {
        if (dto == null || entity == null) {
            return entity;
        }
        
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getSubject() != null) entity.setSubject(dto.getSubject());
        
        if (dto.getSchoolId() != null) {
            School school = new School();
            school.setId(dto.getSchoolId());
            entity.setSchool(school);
        }
        
        return entity;
    }
}