package com.adyakshar.crud.web.api;

import com.adyakshar.crud.web.dto.SchoolDTO;
import java.util.List;

public interface SchoolApi {
    SchoolDTO createSchool(SchoolDTO schoolDTO);
    SchoolDTO getSchoolById(Long id);
    List<SchoolDTO> getAllSchools();
    SchoolDTO updateSchool(Long id, SchoolDTO schoolDTO);
    void deleteSchool(Long id);
}