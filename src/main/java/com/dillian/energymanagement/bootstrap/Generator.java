package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.bootstrap.adjacency.Housing;
import com.dillian.energymanagement.bootstrap.adjacency.Industrial;
import com.dillian.energymanagement.bootstrap.adjacency.Science;
import com.dillian.energymanagement.bootstrap.building.*;
import com.dillian.energymanagement.dtos.AdjacencySet;
import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.entities.building.PublicBuilding;
import com.dillian.energymanagement.entities.building.SpecialBuilding;
import com.dillian.energymanagement.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class Generator {

    private final EnergySourceBootstrap energySourceBootstrap;
    private final GridAssetBootstrap gridAssetBootstrap;
    private final HousingBootstrap housingBootstrap;
    private final IndustrialBuildingBootstrap industrialBuildingBootstrap;
    private final PublicBuildingBootstrap publicBuildingBootstrap;
    private final SpecialBuildingBootstrap specialBuildingBootstrap;
    private final PowerPlantBootstrap powerPlantBootstrap;
    private final EventBootstrap eventBootstrap;
    private final EventRepository eventRepository;
    private final SupervisorBootstrap supervisorBootstrap;
    private final Housing housingAdjacencySet;
    private final Industrial industrialAdjacencySet;
    private final Science scienceAdjacencySet;
    private final Science science;

    private Map<String, SpecialBuilding> specialBuildingsMap = new HashMap<>();

    public Generator(final EnergySourceBootstrap energySourceBootstrap, final GridAssetBootstrap gridAssetBootstrap, final HousingBootstrap housingBootstrap, final IndustrialBuildingBootstrap industrialBuildingBootstrap, final PublicBuildingBootstrap publicBuildingBootstrap, final SpecialBuildingBootstrap specialBuildingBootstrap, final PowerPlantBootstrap powerPlantBootstrap, final EventBootstrap eventBootstrap, final EventRepository eventRepository, final SupervisorBootstrap supervisorBootstrap, final Housing housingAdjacencySet, final Industrial industrialAdjacencySet, final Science scienceAdjacencySet, final Science science) {
        this.energySourceBootstrap = energySourceBootstrap;
        this.gridAssetBootstrap = gridAssetBootstrap;
        this.housingBootstrap = housingBootstrap;
        this.industrialBuildingBootstrap = industrialBuildingBootstrap;
        this.publicBuildingBootstrap = publicBuildingBootstrap;
        this.specialBuildingBootstrap = specialBuildingBootstrap;
        this.powerPlantBootstrap = powerPlantBootstrap;
        this.eventBootstrap = eventBootstrap;
        this.eventRepository = eventRepository;
        this.supervisorBootstrap = supervisorBootstrap;
        this.housingAdjacencySet = housingAdjacencySet;
        this.industrialAdjacencySet = industrialAdjacencySet;
        this.scienceAdjacencySet = scienceAdjacencySet;
        this.science = science;
    }

    public void saveBuildingsAndEvents() {
        createAndSaveBuildings();
        createEvents();
        createSupervisors();
    }

    private void createAndSaveBuildings() {
        try {
            energySourceBootstrap.saveEnergySources();
            gridAssetBootstrap.saveGridAssets();
            housingBootstrap.saveHousingBuildings();
            industrialBuildingBootstrap.saveIndustrialBuildings();
            final List<PublicBuilding> buildings = publicBuildingBootstrap.savePublicBuildings();
            buildings.forEach(building -> log.info(building.toString()));
            powerPlantBootstrap.savePowerPlants();
            specialBuildingsMap = specialBuildingBootstrap.saveSpecialBuildings();
            log.info("All buildings saved");
        } catch (Exception e) {
            log.error("An error occurred: {}", e.getMessage());
        }
    }

    private void createEvents() {
        Event aquaParkEvent = eventBootstrap.createAquaParkEvent(specialBuildingsMap.get("aquaPark"));
        Event themeParkEvent = eventBootstrap.createThemeParkEvent(specialBuildingsMap.get("themePark"));
        Event snowWorld = eventBootstrap.createSnowWorldEvent(specialBuildingsMap.get("snowWorld"));
        Event shoppingResort = eventBootstrap.createShoppingResortEvent(specialBuildingsMap.get("shoppingResort"));
        Event laboratory = eventBootstrap.createLaboratoryEvent(specialBuildingsMap.get("laboratory"));
        eventRepository.saveAll(List.of(aquaParkEvent, themeParkEvent, snowWorld, shoppingResort, laboratory));
        log.info("events successfully created");
    }

    public List<AdjacencySet> createAdjacencySets() {
        return List.of(
                        housingAdjacencySet.createHousingSets(),
                        industrialAdjacencySet.createIndustrialSets(),
                        scienceAdjacencySet.createScienceSets()
                )
                .stream()
                .flatMap(List::stream)
                .toList();
    }

    private void createSupervisors() {
        supervisorBootstrap.create();
    }
}
