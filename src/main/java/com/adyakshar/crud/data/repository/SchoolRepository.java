package com.adyakshar.crud.data.repository;

import com.adyakshar.crud.data.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    // Custom query methods (optional)
}