package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.bootstrap.building.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BuildingGenerator {

    private final EnergySourceBootstrap energySourceBootstrap;
    private final GridAssetBootstrap gridAssetBootstrap;
    private final HousingBootstrap housingBootstrap;
    private final IndustrialBuildingBootstrap industrialBuildingBootstrap;
    private final PublicBuildingBootstrap publicBuildingBootstrap;
    private final SpecialBuildingBootstrap specialBuildingBootstrap;
    private final PowerPlantBootstrap powerPlantBootstrap;

    public void createAndSaveAllBuildings() {
        energySourceBootstrap.saveEnergySources();
        gridAssetBootstrap.saveGridAssets();
        housingBootstrap.saveHousingBuildings();
        industrialBuildingBootstrap.saveIndustrialBuildings();
        publicBuildingBootstrap.savePublicBuildings();
        specialBuildingBootstrap.saveSpecialBuildings();
        powerPlantBootstrap.savePowerPlants();
    }
}
