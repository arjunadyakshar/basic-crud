package com.adyakshar.crud.web.api;

import com.adyakshar.crud.web.dto.ParentDTO;
import java.util.List;

public interface ParentApi {
    ParentDTO createParent(ParentDTO parentDTO);
    ParentDTO getParentById(Long id);
    List<ParentDTO> getAllParents();
    ParentDTO updateParent(Long id, ParentDTO parentDTO);
    void deleteParent(Long id);
}