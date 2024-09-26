package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.dtos.BuildingsRequestDto;
import com.dillian.energymanagement.services.BuildingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/source")
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


    @GetMapping("all")
    public ResponseEntity<List<BuildingDTO>> findAllById(@RequestBody BuildingsRequestDto requestDto) {
        return ResponseEntity
                .ok(buildingService.findAllById(requestDto.getIds()));
    }

    @GetMapping("{id}")
    public ResponseEntity<BuildingDTO> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity
                .ok(buildingService.findById(id));
    }
}

