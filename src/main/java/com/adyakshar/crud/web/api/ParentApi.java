package com.adyakshar.crud.web.api;

import com.adyakshar.crud.data.model.Parent;
import java.util.List;

public interface ParentApi {
    Parent createParent(Parent parent);
    Parent getParentById(Long id);
    List<Parent> getAllParents();
    Parent updateParent(Long id, Parent parent);
    void deleteParent(Long id);
}