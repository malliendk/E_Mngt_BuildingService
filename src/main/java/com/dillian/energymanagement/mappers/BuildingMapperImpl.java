package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.dtos.SolarPanelDTO;
import com.dillian.energymanagement.entities.BuildingVisitor;
import com.dillian.energymanagement.entities.building.*;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapperImpl implements BuildingVisitor {

    @Override
    public BuildingDTO toDTO(PublicBuilding publicBuilding) {
        BuildingDTO buildingDTO = createWithGenericProperties(publicBuilding);
        buildingDTO.setGoldIncome(publicBuilding.getGoldIncome());
        buildingDTO.setPopularityIncome(publicBuilding.getPopularityIncome());
        buildingDTO.setResearchIncome(publicBuilding.getResearchIncome());
        buildingDTO.setEnergyProduction(publicBuilding.getEnergyProduction());
        buildingDTO.setEnergyConsumption(publicBuilding.getEnergyConsumption());
        buildingDTO.setEnvironmentalScore(publicBuilding.getEnvironmentalScore());
        buildingDTO.setHousingRequirement(publicBuilding.getHousingRequirement());
        buildingDTO.setCanBePurchased(publicBuilding.isCanBePurchased());
        return buildingDTO;
    }

    @Override
    public BuildingDTO toDTO(PowerPlant powerPlant) {
        BuildingDTO buildingDTO = createWithGenericProperties(powerPlant);
        buildingDTO.setEnergyProduction(powerPlant.getEnergyProduction());
        return buildingDTO;
    }

    @Override
    public BuildingDTO toDTO(IndustrialBuilding industrialBuilding) {
        BuildingDTO buildingDTO = createWithGenericProperties(industrialBuilding);
        buildingDTO.setEnergyConsumption(industrialBuilding.getEnergyConsumption());
        buildingDTO.setGoldIncome(industrialBuilding.getGoldIncome());
        return buildingDTO;
    }

    @Override
    public BuildingDTO toDTO(EnergySource energySource) {
        BuildingDTO buildingDTO = createWithGenericProperties(energySource);
        buildingDTO.setEnergyProduction(energySource.getEnergyProduction());
        buildingDTO.setPopularityIncome(energySource.getPopularityIncome());
        buildingDTO.setEnvironmentalScore(energySource.getEnvironmentalScore());
        return buildingDTO;
    }

    @Override
    public BuildingDTO toDTO(Utility utility) {
        BuildingDTO buildingDTO = createWithGenericProperties(utility);
        buildingDTO.setGridCapacity(utility.getGridCapacity());
        return buildingDTO;
    }

    @Override
    public BuildingDTO toDTO(Housing housing) {
        BuildingDTO buildingDTO = createWithGenericProperties(housing);
        buildingDTO.setHousing(housing.getHousing());
        if (housing.getSolarPanelSet() != null) {
            SolarPanelDTO solarPanelSet = housing.getSolarPanelSet();
            buildingDTO.setEnergyProduction(housing.getSolarPanelAmount() * solarPanelSet.getEnergyProductionExtra());
            buildingDTO.setGoldIncome(housing.getGoldIncome() * solarPanelSet.getGoldIncomeExtra());
            buildingDTO.setResearchIncome(housing.getSolarPanelAmount() * solarPanelSet.getResearchIncomeExtra());
            buildingDTO.setEnvironmentalScore(housing.getSolarPanelAmount() * solarPanelSet.getEnvironmentalScoreExtra());
        } else {
            buildingDTO.setGoldIncome(housing.getGoldIncome());
        }
        buildingDTO.setEnergyConsumption(housing.getEnergyConsumption());
        buildingDTO.setPopularityIncome(housing.getPopularityIncome());
        return buildingDTO;
    }

    @Override
    public BuildingDTO toDTO(SpecialBuilding specialBuilding) {
        BuildingDTO buildingDTO = createWithGenericProperties(specialBuilding);
        buildingDTO.setEnergyConsumption(specialBuilding.getEnergyConsumption());
        buildingDTO.setResearchIncome(specialBuilding.getResearchIncome());
        buildingDTO.setPopularityIncome(specialBuilding.getPopularityIncome());
        buildingDTO.setGoldIncome(specialBuilding.getGoldIncome());
        buildingDTO.setPopularityCost(specialBuilding.getPopularityCost());
        return buildingDTO;
    }

    private BuildingDTO createWithGenericProperties(Building building) {
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(building.getId());
        buildingDTO.setName(building.getName());
        buildingDTO.setDescription(building.getDescription());
        buildingDTO.setPrice(building.getPrice());
        buildingDTO.setImageUri(building.getImageUri());
        buildingDTO.setCategory(building.getCategory());
        return buildingDTO;
    }
}
