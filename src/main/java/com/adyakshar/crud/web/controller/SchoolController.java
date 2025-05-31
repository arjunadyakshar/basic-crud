package com.adyakshar.crud.web.controller;

import com.adyakshar.crud.data.model.School;
import com.adyakshar.crud.web.api.SchoolApi;
import com.adyakshar.crud.service.SchoolService;
import com.adyakshar.crud.web.dto.SchoolDTO;
import com.adyakshar.crud.web.mapper.SchoolMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController implements SchoolApi {

    private final SchoolService schoolService;
    private final SchoolMapper schoolMapper;

    public SchoolController(SchoolService schoolService, SchoolMapper schoolMapper) {
        this.schoolService = schoolService;
        this.schoolMapper = schoolMapper;
    }

    @PostMapping
    public SchoolDTO createSchool(@RequestBody SchoolDTO schoolDTO) {
        School school = schoolMapper.toEntity(schoolDTO);
        School createdSchool = schoolService.createSchool(school);
        return schoolMapper.toDto(createdSchool);
    }

    @GetMapping("/{id}")
    public SchoolDTO getSchoolById(@PathVariable Long id) {
        School school = schoolService.getSchoolById(id);
        return schoolMapper.toDto(school);
    }

    @GetMapping
    public List<SchoolDTO> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return schoolMapper.toDtoList(schools);
    }

    @PutMapping("/{id}")
    public SchoolDTO updateSchool(@PathVariable Long id, @RequestBody SchoolDTO schoolDTO) {
        School school = schoolService.getSchoolById(id);
        school = schoolMapper.updateEntity(schoolDTO, school);
        School updatedSchool = schoolService.updateSchool(id, school);
        return schoolMapper.toDto(updatedSchool);
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }
}