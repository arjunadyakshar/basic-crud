package com.adyakshar.crud.web.controller;

import com.adyakshar.crud.data.model.School;
import com.adyakshar.crud.web.api.SchoolApi;
import com.adyakshar.crud.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController implements SchoolApi {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @PutMapping("/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
        return schoolService.updateSchool(id, school);
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }
}