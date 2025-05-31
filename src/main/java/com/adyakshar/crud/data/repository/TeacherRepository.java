package com.adyakshar.crud.data.repository;

import com.adyakshar.crud.data.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Optional: List<Teacher> findBySchoolId(Long schoolId);
}