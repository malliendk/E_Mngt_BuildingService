package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.entities.building.Building;
import com.dillian.energymanagement.mappers.BuildingMapper;
import com.dillian.energymanagement.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingMapper mapper;

    private final EnergySourceRepository energySourceRepository;
    private final GridAssetRepository gridAssetRepository;
    private final HousingRepository housingRepository;
    private final PublicBuildingRepository publicBuildingRepository;
    private final FactoryRepository factoryRepository;

    @Override
    public List<BuildingDTO> findAll() {
        List<BuildingDTO> publicBuildings = publicBuildingRepository.findAll()
                .stream()
                .map(mapper::toBuildingDTO)
                .toList();
        List<BuildingDTO> factories = factoryRepository.findAll()
                .stream()
                .map(mapper::toBuildingDTO)
                .toList();
        List<BuildingDTO> gridAssets = gridAssetRepository.findAll()
                .stream()
                .map(mapper::toBuildingDTO)
                .toList();
        List<BuildingDTO> energySources = energySourceRepository.findAll()
                .stream()
                .map(mapper::toBuildingDTO)
                .toList();
        List<BuildingDTO> houseHolds = housingRepository.findAll()
                .stream()
                .map(mapper::toBuildingDTO)
                .toList();
        return Stream.of(publicBuildings, factories, gridAssets, energySources, houseHolds)
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public List<BuildingDTO> findAllById(List<Long> ids) {
        return findAll()
                .stream()
                .filter(buildingDTO -> ids.contains(buildingDTO.getId()))
                .toList();
    }

    @Override
    public BuildingDTO findById(Long id) {
        List<Optional<? extends Building>> candidateBuildings = List.of(
                publicBuildingRepository.findById(id),
                energySourceRepository.findById(id),
                housingRepository.findById(id),
                gridAssetRepository.findById(id),
                factoryRepository.findById(id));
        List<? extends Building> foundBuilding = candidateBuildings
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        if (foundBuilding.isEmpty()) {
            throw new RuntimeException("No buildings found with this id");
        } else if (foundBuilding.size() > 1) {
            throw new RuntimeException("More than one building with the same id found");
        }
        return foundBuilding.getFirst().toBuildingDTO(mapper);
    }


}
