package com.adyakshar.crud.service;

import com.adyakshar.crud.data.model.Parent;
import com.adyakshar.crud.data.repository.ParentRepository;
import com.adyakshar.crud.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public Parent getParentById(Long id) {
        return parentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parent not found with id: " + id));
    }

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Parent updateParent(Long id, Parent parent) {
        Parent existingParent = getParentById(id);
        existingParent.setName(parent.getName());
        existingParent.setEmail(parent.getEmail());
        return parentRepository.save(existingParent);
    }

    public void deleteParent(Long id) {
        if (!parentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Parent not found with id: " + id);
        }
        parentRepository.deleteById(id);
    }
}