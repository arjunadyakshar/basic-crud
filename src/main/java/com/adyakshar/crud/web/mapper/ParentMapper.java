package com.adyakshar.crud.web.mapper;

import com.adyakshar.crud.data.model.Parent;
import com.adyakshar.crud.data.model.Student;
import com.adyakshar.crud.web.dto.ParentDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParentMapper extends BaseEntityMapper<Parent, ParentDTO> {

    public ParentDTO toDto(Parent entity) {
        if (entity == null) {
            return null;
        }

        ParentDTO dto = new ParentDTO();
        mapToDto(entity, dto);
        
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setAge(entity.getAge());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        
        if (entity.getChildren() != null) {
            dto.setChildrenIds(entity.getChildren().stream()
                .map(Student::getId)
                .collect(Collectors.toList()));
        } else {
            dto.setChildrenIds(Collections.emptyList());
        }
        
        return dto;
    }
    
    public List<ParentDTO> toDtoList(List<Parent> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        
        return entities.stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }
    
    public Parent toEntity(ParentDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Parent entity = new Parent();
        mapToEntity(dto, entity);
        
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAge(dto.getAge());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        
        // We don't set the children here to avoid circular references
        // That would typically be handled by the service layer
        
        return entity;
    }
    
    public Parent updateEntity(ParentDTO dto, Parent entity) {
        if (dto == null || entity == null) {
            return entity;
        }
        
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getAge() != null) entity.setAge(dto.getAge());
        if (dto.getAddress() != null) entity.setAddress(dto.getAddress());
        if (dto.getPhoneNumber() != null) entity.setPhoneNumber(dto.getPhoneNumber());
        
        return entity;
    }
}