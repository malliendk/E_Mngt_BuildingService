package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.services.BuildingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("building")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping
    public ResponseEntity<List<BuildingDTO>> findAll() {
        List<BuildingDTO> loadSources = buildingService.findAll();
        return ResponseEntity.ok(loadSources);
    }

    @GetMapping("ids")
    public ResponseEntity<List<BuildingDTO>> findAllById(@RequestParam List<Long> ids) {
        return ResponseEntity
                .ok(buildingService.findAllById(ids));
    }

    @GetMapping("{id}")
    public ResponseEntity<BuildingDTO> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity
                .ok(buildingService.findById(id));
    }
}

