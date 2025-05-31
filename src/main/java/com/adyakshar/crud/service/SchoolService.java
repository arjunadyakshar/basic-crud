package com.adyakshar.crud.service;

import com.adyakshar.crud.data.model.School;
import com.adyakshar.crud.data.repository.SchoolRepository;
import com.adyakshar.crud.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("School not found with id: " + id));
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School updateSchool(Long id, School school) {
        School existingSchool = getSchoolById(id);
        existingSchool.setName(school.getName());
        existingSchool.setAddress(school.getAddress());
        return schoolRepository.save(existingSchool);
    }

    public void deleteSchool(Long id) {
        if (!schoolRepository.existsById(id)) {
            throw new ResourceNotFoundException("School not found with id: " + id);
        }
        schoolRepository.deleteById(id);
    }
}