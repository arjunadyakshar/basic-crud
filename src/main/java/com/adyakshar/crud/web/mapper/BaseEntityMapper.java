package com.adyakshar.crud.web.mapper;

import com.adyakshar.crud.data.model.BaseEntity;
import com.adyakshar.crud.web.dto.BaseEntityDTO;

public abstract class BaseEntityMapper<E extends BaseEntity, D extends BaseEntityDTO> {
    
    protected D mapToDto(E entity, D dto) {
        if (entity == null) {
            return null;
        }
        
        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        
        return dto;
    }
    
    protected E mapToEntity(D dto, E entity) {
        if (dto == null) {
            return null;
        }
        
        // Don't override ID during creation, only during updates
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        
        // Usually we don't set createdAt/updatedAt from DTO as they're managed by JPA
        // entity.setCreatedAt(dto.getCreatedAt());
        // entity.setUpdatedAt(dto.getUpdatedAt());
        
        return entity;
    }
}