package com.adyakshar.crud.web.api;

import com.adyakshar.crud.data.model.Teacher;
import java.util.List;

public interface TeacherApi {
    Teacher createTeacher(Teacher teacher);
    Teacher getTeacherById(Long id);
    List<Teacher> getAllTeachers();
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);
}