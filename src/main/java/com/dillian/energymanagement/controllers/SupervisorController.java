package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.dtos.SupervisorDTO;
import com.dillian.energymanagement.services.SupervisorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supervisor")
@AllArgsConstructor
public class SupervisorController {

    private final SupervisorService supervisorService;

    @GetMapping
    public ResponseEntity<List<Supervisor>> getAll() {
        return ResponseEntity
                .ok(supervisorService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<SupervisorDTO> getById(@PathVariable Long id) {
        return ResponseEntity
                .ok(supervisorService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<SupervisorDTO> update(@PathVariable Long id, @RequestBody SupervisorDTO supervisorDTO) {
        return ResponseEntity.ok(supervisorService.update(id, supervisorDTO));
    }
}
