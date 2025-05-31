package com.adyakshar.crud.service;

import com.adyakshar.crud.data.model.Teacher;
import com.adyakshar.crud.data.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher existingTeacher = getTeacherById(id);
        existingTeacher.setName(teacher.getName());
        existingTeacher.setSubject(teacher.getSubject());
        return teacherRepository.save(existingTeacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}