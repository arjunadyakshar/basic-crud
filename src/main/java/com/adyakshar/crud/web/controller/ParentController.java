package com.adyakshar.crud.web.controller;

import com.adyakshar.crud.data.model.Parent;
import com.adyakshar.crud.web.api.ParentApi;
import com.adyakshar.crud.service.ParentService;
import com.adyakshar.crud.web.dto.ParentDTO;
import com.adyakshar.crud.web.mapper.ParentMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController implements ParentApi {

    private final ParentService parentService;
    private final ParentMapper parentMapper;

    public ParentController(ParentService parentService, ParentMapper parentMapper) {
        this.parentService = parentService;
        this.parentMapper = parentMapper;
    }

    @PostMapping
    public ParentDTO createParent(@RequestBody ParentDTO parentDTO) {
        Parent parent = parentMapper.toEntity(parentDTO);
        Parent createdParent = parentService.createParent(parent);
        return parentMapper.toDto(createdParent);
    }

    @GetMapping("/{id}")
    public ParentDTO getParentById(@PathVariable Long id) {
        Parent parent = parentService.getParentById(id);
        return parentMapper.toDto(parent);
    }

    @GetMapping
    public List<ParentDTO> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return parentMapper.toDtoList(parents);
    }

    @PutMapping("/{id}")
    public ParentDTO updateParent(@PathVariable Long id, @RequestBody ParentDTO parentDTO) {
        Parent parent = parentService.getParentById(id);
        parent = parentMapper.updateEntity(parentDTO, parent);
        Parent updatedParent = parentService.updateParent(id, parent);
        return parentMapper.toDto(updatedParent);
    }

    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
    }
}