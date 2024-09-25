package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.EnergySourceDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import com.dillian.energymanagement.repositories.BuildingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingMapper mapper;

    private final BuildingRepository buildingRepository;

    @Override
    public List<EnergySourceDTO> findAll() {
        return buildingRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public EnergySourceDTO findById(Long id){
        return buildingRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow();
    }


    @Override
    public EnergySourceDTO findByName(String name){
        return buildingRepository.findByName(name)
                .map(mapper::toDto)
                .orElseThrow();
    }
}
