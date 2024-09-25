package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.EnergySourceDTO;
import com.dillian.energymanagement.services.BuildingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/source")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping
    public ResponseEntity<List<EnergySourceDTO>> findAll() {
        List<EnergySourceDTO> loadSources = buildingService.findAll();
        return ResponseEntity.ok(loadSources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnergySourceDTO> findById(@PathVariable Long id) {
        try {
            EnergySourceDTO loadSource = buildingService.findById(id);
            return ResponseEntity.ok(loadSource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<EnergySourceDTO> findByName(@PathVariable String name) {
        try {
            EnergySourceDTO loadSource = buildingService.findByName(name);
            return ResponseEntity.ok(loadSource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

