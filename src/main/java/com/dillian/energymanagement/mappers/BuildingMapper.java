package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.entities.building.*;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper {

    public BuildingDTO toBuildingDTO(PublicBuilding publicBuilding) {
        BuildingDTO buildingDTO = createWithGenericProperties(publicBuilding);
        buildingDTO.setGridLoad(publicBuilding.getGridLoad());
        buildingDTO.setEnergyConsumption(publicBuilding.getEnergyConsumption());
        buildingDTO.setResearchYield(buildingDTO.getResearchYield());
        buildingDTO.setPopularityYield(buildingDTO.getPopularityYield());
        return buildingDTO;
    }

    public BuildingDTO toBuildingDTO(Factory factory) {
        BuildingDTO buildingDTO = createWithGenericProperties(factory);
        buildingDTO.setEnergyProduction(factory.getEnergyProduction());
        buildingDTO.setGridLoad(buildingDTO.getGridLoad());
        buildingDTO.setPrice(factory.getPrice());
        return buildingDTO;
    }

    public BuildingDTO toBuildingDTO(EnergySource energySource) {
        BuildingDTO buildingDTO = createWithGenericProperties(energySource);
        buildingDTO.setGridLoad(energySource.getGridLoad());
        buildingDTO.setEnergyProduction(energySource.getEnergyProduction());
        return buildingDTO;
    }

    public BuildingDTO toBuildingDTO(GridAsset gridAsset) {
        BuildingDTO buildingDTO = createWithGenericProperties(gridAsset);
        buildingDTO.setGridLoad(gridAsset.getGridCapacityIncrease());
        return buildingDTO;
    }

    public BuildingDTO toBuildingDTO(Housing housing) {
        BuildingDTO buildingDTO = createWithGenericProperties(housing);
        buildingDTO.setEnergyConsumption(housing.getEnergyConsumption());
        buildingDTO.setHouseHolds(housing.getHouseHolds());
        return buildingDTO;
    }



    private BuildingDTO createWithGenericProperties(Building building) {
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(building.getId());
        buildingDTO.setName(building.getName());
        buildingDTO.setDescription(building.getDescription());
        buildingDTO.setPrice(building.getPrice());
        buildingDTO.setImageUri(buildingDTO.getImageUri());
        return buildingDTO;
    }
}
