package com.adyakshar.crud.web.api;

import com.adyakshar.crud.data.model.Student;
import java.util.List;

public interface StudentApi {
    Student createStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}