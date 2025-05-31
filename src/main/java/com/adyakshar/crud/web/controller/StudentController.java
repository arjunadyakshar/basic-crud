package com.adyakshar.crud.web.controller;

import com.adyakshar.crud.data.model.Student;
import com.adyakshar.crud.web.api.StudentApi;
import com.adyakshar.crud.service.StudentService;
import com.adyakshar.crud.web.dto.StudentDTO;
import com.adyakshar.crud.web.mapper.StudentMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController implements StudentApi {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student createdStudent = studentService.createStudent(student);
        return studentMapper.toDto(createdStudent);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return studentMapper.toDto(student);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return studentMapper.toDtoList(students);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        Student student = studentService.getStudentById(id);
        student = studentMapper.updateEntity(studentDTO, student);
        Student updatedStudent = studentService.updateStudent(id, student);
        return studentMapper.toDto(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}