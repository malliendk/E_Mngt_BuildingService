package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.AdjacencySet;
import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.services.BuildingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@Slf4j
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("ids")
    public ResponseEntity<List<BuildingDTO>> findAllById(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(buildingService.findAllById(ids));
    }

    @GetMapping()
    public List<BuildingDTO> findAll() {
        return buildingService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<BuildingDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(buildingService.findById(id));
    }

    @GetMapping("power-plant")
    public ResponseEntity<List<BuildingDTO>> findAllPowerPlants() {
        return ResponseEntity.ok(buildingService.findAllPowerPlants());
    }

    @GetMapping("adjacency-sets")
    public ResponseEntity<List<AdjacencySet>> findAllAdjacencySets() {
        return ResponseEntity.ok(buildingService.findAllAdjacencySets());
    }
}

