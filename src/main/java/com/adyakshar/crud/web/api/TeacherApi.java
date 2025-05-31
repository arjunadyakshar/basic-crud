package com.adyakshar.crud.web.api;

import com.adyakshar.crud.web.dto.TeacherDTO;
import java.util.List;

public interface TeacherApi {
    TeacherDTO createTeacher(TeacherDTO teacherDTO);
    TeacherDTO getTeacherById(Long id);
    List<TeacherDTO> getAllTeachers();
    TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO);
    void deleteTeacher(Long id);
}