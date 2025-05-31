package com.adyakshar.crud.web.api;

import com.adyakshar.crud.web.dto.StudentDTO;
import java.util.List;

public interface StudentApi {
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
}