package com.adyakshar.crud.data.repository;

import com.adyakshar.crud.data.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
    // Custom query methods (optional)
}
