package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.EnergySourceDTO;

import java.util.List;

public interface BuildingService {
    EnergySourceDTO findById(Long id);

    EnergySourceDTO findByName(String name);

    List<EnergySourceDTO> findAll();
}
