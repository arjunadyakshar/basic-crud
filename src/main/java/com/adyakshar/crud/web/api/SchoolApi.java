package com.adyakshar.crud.web.api;

import com.adyakshar.crud.data.model.School;
import java.util.List;

public interface SchoolApi {
    School createSchool(School school);
    School getSchoolById(Long id);
    List<School> getAllSchools();
    School updateSchool(Long id, School school);
    void deleteSchool(Long id);
}