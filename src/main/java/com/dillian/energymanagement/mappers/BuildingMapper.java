package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.dtos.SolarPanelDTO;
import com.dillian.energymanagement.entities.building.*;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper {

    public BuildingDTO publicBuildingToDTO(PublicBuilding publicBuilding) {
        BuildingDTO buildingDTO = createWithGenericProperties(publicBuilding);
        buildingDTO.setPopularityIncome(publicBuilding.getPopularityIncome());
        int solarPanelAmount = publicBuilding.getSolarPanelAmount();
        buildingDTO.setSolarPanelAmount(solarPanelAmount);
        SolarPanelDTO solarPanelDTO;
        if (publicBuilding.getSolarPanelSet() != null) {
            solarPanelDTO = publicBuilding.getSolarPanelSet();
            buildingDTO.setSolarPanels(publicBuilding.getSolarPanelSet());
            buildingDTO.setEnergyProduction(solarPanelDTO.getEnergyProductionExtra() * solarPanelAmount);
            buildingDTO.setGoldIncome(solarPanelDTO.getGoldIncomeExtra() * solarPanelAmount);
            buildingDTO.setResearchIncome(solarPanelDTO.getResearchIncomeExtra() * solarPanelAmount);
        } else {
            buildingDTO.setResearchIncome(publicBuilding.getResearchIncome());
        }
        buildingDTO.setSolarPanelCapacity(publicBuilding.getSolarPanelCapacity());
        buildingDTO.setEnergyConsumption(publicBuilding.getEnergyConsumption());
        return buildingDTO;
    }

    public BuildingDTO powerPlantToDTO(PowerPlant powerPlant) {
        BuildingDTO buildingDTO = createWithGenericProperties(powerPlant);
        buildingDTO.setEnergyProduction(powerPlant.getEnergyProduction());
        return buildingDTO;
    }

    public BuildingDTO industrialBuildingToDTO(IndustrialBuilding industrialBuilding) {
        BuildingDTO buildingDTO = createWithGenericProperties(industrialBuilding);
        buildingDTO.setEnergyConsumption(industrialBuilding.getEnergyConsumption());
        buildingDTO.setGoldIncome(industrialBuilding.getGoldIncome());
        return buildingDTO;
    }

    public BuildingDTO energySourceToDTO(EnergySource energySource) {
        BuildingDTO buildingDTO = createWithGenericProperties(energySource);
        buildingDTO.setEnergyProduction(energySource.getEnergyProduction());
        buildingDTO.setPopularityIncome(energySource.getPopularityIncome());
        buildingDTO.setEnvironmentalScore(energySource.getEnvironmentalScore());
        return buildingDTO;
    }

    public BuildingDTO gridAssetToDTO(GridAsset gridAsset) {
        BuildingDTO buildingDTO = createWithGenericProperties(gridAsset);
        buildingDTO.setGridCapacity(gridAsset.getGridCapacity());
        return buildingDTO;
    }

    public BuildingDTO housingToDTO(Housing housing) {
        BuildingDTO buildingDTO = createWithGenericProperties(housing);
        buildingDTO.setHouseHolds(housing.getHouseHolds());
        if (housing.getSolarPanelSet() != null) {
            SolarPanelDTO solarPanelSet = housing.getSolarPanelSet();
            buildingDTO.setSolarPanels(housing.getSolarPanelSet());
            buildingDTO.setEnergyProduction(housing.getSolarPanelAmount() * solarPanelSet.getEnergyProductionExtra());
            buildingDTO.setGoldIncome(housing.getGoldIncome() * solarPanelSet.getGoldIncomeExtra());
            buildingDTO.setResearchIncome(housing.getSolarPanelAmount() * solarPanelSet.getResearchIncomeExtra());
            buildingDTO.setEnvironmentalScore(housing.getSolarPanelAmount() * solarPanelSet.getEnvironmentalScoreExtra());
        } else {
            buildingDTO.setGoldIncome(housing.getGoldIncome());
        }
        buildingDTO.setEnergyConsumption(housing.getEnergyConsumption());
        buildingDTO.setPopularityIncome(housing.getPopularityIncome());
        buildingDTO.setSolarPanelAmount(housing.getSolarPanelAmount());
        buildingDTO.setSolarPanelCapacity(housing.getSolarPanelCapacity());
        return buildingDTO;
    }

    public BuildingDTO specialBuildingToDTO(SpecialBuilding specialBuilding) {
        BuildingDTO buildingDTO = createWithGenericProperties(specialBuilding);
        buildingDTO.setEnergyConsumption(specialBuilding.getEnergyConsumption());
        buildingDTO.setResearchIncome(specialBuilding.getResearchIncome());
        buildingDTO.setPopularityIncome(specialBuilding.getPopularityIncome());
        buildingDTO.setGoldIncome(specialBuilding.getGoldIncome());
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
        buildingDTO.setCanBePurchased(building.isCanBePurchased());
        buildingDTO.setPurchased(building.isPurchased());
        return buildingDTO;
    }
}
