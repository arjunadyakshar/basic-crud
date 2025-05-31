package com.adyakshar.crud.data.repository;

import com.adyakshar.crud.data.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // You could add queries like:
    // List<Student> findByParentId(Long parentId);
    // List<Student> findBySchoolId(Long schoolId);
}
