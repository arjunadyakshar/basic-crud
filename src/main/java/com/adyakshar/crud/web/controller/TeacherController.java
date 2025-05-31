package com.adyakshar.crud.web.controller;

import com.adyakshar.crud.data.model.Teacher;
import com.adyakshar.crud.web.api.TeacherApi;
import com.adyakshar.crud.service.TeacherService;
import com.adyakshar.crud.web.dto.TeacherDTO;
import com.adyakshar.crud.web.mapper.TeacherMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController implements TeacherApi {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    public TeacherController(TeacherService teacherService, TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
    }

    @PostMapping
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return teacherMapper.toDto(createdTeacher);
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return teacherMapper.toDto(teacher);
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return teacherMapper.toDtoList(teachers);
    }

    @PutMapping("/{id}")
    public TeacherDTO updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = teacherService.getTeacherById(id);
        teacher = teacherMapper.updateEntity(teacherDTO, teacher);
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
        return teacherMapper.toDto(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}