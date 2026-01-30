package com.dillian.energymanagement.services;


import com.dillian.energymanagement.bootstrap.Generator;
import com.dillian.energymanagement.constants.BuildingIds;
import com.dillian.energymanagement.constants.CategoryNames;
import com.dillian.energymanagement.dtos.AdjacencySet;
import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.entities.building.Building;
import com.dillian.energymanagement.mappers.BuildingMapperImpl;
import com.dillian.energymanagement.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class BuildingService {

    private final BuildingMapperImpl dtoMapper;
    private final EnergySourceRepository energySourceRepository;
    private final GridAssetRepository gridAssetRepository;
    private final HousingRepository housingRepository;
    private final PublicBuildingRepository publicBuildingRepository;
    private final PowerPlantRepository powerPlantRepository;
    private final IndustrialBuildingRepository industrialBuildingRepository;
    private final SpecialBuildingsRepository specialBuildingsRepository;
    private final Generator generator;

    public List<BuildingDTO> findAll() {
        List<String> categoryOrder = List.of(CategoryNames.CATEGORY_HOUSING, CategoryNames.CATEGORY_PUBLIC_BUILDING,
                CategoryNames.CATEGORY_INDUSTRIAL, CategoryNames.CATEGORY_ENERGY_PRODUCTION,
                CategoryNames.CATEGORY_POWER_PLANT, CategoryNames.CATEGORY_SPECIAL_BUILDING, CategoryNames.CATEGORY_GRID_ASSET);
        return Stream.of(
                        housingRepository.findAll(),
                        energySourceRepository.findAll(),
                        gridAssetRepository.findAll(),
                        publicBuildingRepository.findAll(),
                        powerPlantRepository.findAll(),
                        industrialBuildingRepository.findAll(),
                        specialBuildingsRepository.findAll()
                )
                .flatMap(List::stream)
                .map(building -> building.accept(dtoMapper))
                .sorted(Comparator.comparing((BuildingDTO b)
                                -> categoryOrder.indexOf(b.getCategory()))
                        .thenComparing(BuildingDTO::getPrice))
                .toList();
    }

    public List<BuildingDTO> findAllPurchasable() {
        return findAll().stream()
                .filter(buildingDTO -> !buildingDTO.getCategory().equals(CategoryNames.CATEGORY_POWER_PLANT) &&
                        !buildingDTO.getCategory().equals(CategoryNames.CATEGORY_SPECIAL_BUILDING) &&
                        !buildingDTO.getId().equals(BuildingIds.TOWN_HALL))
                .toList();
    }

    public List<BuildingDTO> findAllPowerPlants() {
        return powerPlantRepository.findAll().stream()
                .map(dtoMapper::toDTO)
                .toList();
    }

    public List<BuildingDTO> findAllById(List<Long> ids) {
        List<BuildingDTO> buildings = new ArrayList<>();
        for (Long id : ids) {
            findAll().stream()
                    .filter(buildingDTO -> buildingDTO.getId().equals(id))
                    .findFirst()
                    .ifPresent(buildings::add);
        }
        return buildings;
    }

    public BuildingDTO findById(Long id) {
        List<Optional<? extends Building>> candidateBuildings = List.of(
                publicBuildingRepository.findById(id),
                energySourceRepository.findById(id),
                housingRepository.findById(id),
                gridAssetRepository.findById(id),
                powerPlantRepository.findById(id),
                industrialBuildingRepository.findById(id));
        List<? extends Building> foundBuilding = candidateBuildings
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        return foundBuilding.getFirst().accept(dtoMapper);
    }

    public List<AdjacencySet> findAllAdjacencySets() {
        return generator.createAdjacencySets();
    }
}
