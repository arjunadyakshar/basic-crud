package com.adyakshar.crud.web.controller;

import com.adyakshar.crud.data.model.Parent;
import com.adyakshar.crud.web.api.ParentApi;
import com.adyakshar.crud.service.ParentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController implements ParentApi {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping
    public Parent createParent(@RequestBody Parent parent) {
        return parentService.createParent(parent);
    }

    @GetMapping("/{id}")
    public Parent getParentById(@PathVariable Long id) {
        return parentService.getParentById(id);
    }

    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @PutMapping("/{id}")
    public Parent updateParent(@PathVariable Long id, @RequestBody Parent parent) {
        return parentService.updateParent(id, parent);
    }

    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
    }
}