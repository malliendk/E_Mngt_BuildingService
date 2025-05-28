package com.dillian.energymanagement.entities;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.entities.building.*;

public interface BuildingVisitor {

    BuildingDTO toDTO(Housing housing);

    BuildingDTO toDTO(PublicBuilding publicBuilding);

    BuildingDTO toDTO(PowerPlant powerPlant);

    BuildingDTO toDTO(IndustrialBuilding industrialBuilding);

    BuildingDTO toDTO(EnergySource energySource);

    BuildingDTO toDTO(Utility utility);

    BuildingDTO toDTO(SpecialBuilding specialBuilding);
}
