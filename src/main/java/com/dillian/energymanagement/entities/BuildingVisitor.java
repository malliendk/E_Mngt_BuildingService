package com.dillian.energymanagement.entities;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.entities.building.*;

public interface BuildingVisitor {

    BuildingDTO visit(Housing housing);

    BuildingDTO forPublicBuilding(PublicBuilding publicBuilding);

    BuildingDTO visit(PowerPlant powerPlant);

    BuildingDTO visit(IndustrialBuilding industrialBuilding);

    BuildingDTO visit(EnergySource energySource);

    BuildingDTO visit(Utility utility);

    BuildingDTO visit(SpecialBuilding specialBuilding);
}
