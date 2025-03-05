package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.entities.building.Building;
import com.dillian.energymanagement.mappers.BuildingMapper;
import com.dillian.energymanagement.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class BuildingService {

    private final BuildingMapper mapper;
    private final EnergySourceRepository energySourceRepository;
    private final GridAssetRepository gridAssetRepository;
    private final HousingRepository housingRepository;
    private final PublicBuildingRepository publicBuildingRepository;
    private final PowerPlantRepository powerPlantRepository;
    private final SpecialBuildingsRepository specialBuildingsRepository;
    private final IndustrialBuildingRepository industrialBuildingRepository;

    public List<BuildingDTO> findAll() {
        return Stream.of(
                        housingRepository.findAll(),
                        energySourceRepository.findAll(),
                        gridAssetRepository.findAll(),
                        publicBuildingRepository.findAll(),
                        powerPlantRepository.findAll(),
                        industrialBuildingRepository.findAll()
                )
                .flatMap(List::stream)
                .map(building -> building.accept(mapper))
                .sorted(Comparator.comparing(BuildingDTO::getCategory).reversed()
                        .thenComparing(BuildingDTO::getPrice))
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
        return foundBuilding.getFirst().accept(mapper);
    }
}
