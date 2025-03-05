package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.services.BuildingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("ids")
    public ResponseEntity<List<BuildingDTO>> findAllById(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(buildingService.findAllById(ids));
    }

    @GetMapping
    public ResponseEntity<List<BuildingDTO>> findAll() {
        List<BuildingDTO> loadSources = buildingService.findAll();
        return ResponseEntity.ok(loadSources);
    }

    @GetMapping("{id}")
    public ResponseEntity<BuildingDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(buildingService.findById(id));
    }
}

