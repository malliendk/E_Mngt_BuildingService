package com.dillian.energymanagement.services;


import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.entities.*;
import com.dillian.energymanagement.mappers.BuildingMapper;
import com.dillian.energymanagement.repositories.EnergySourceRepository;
import com.dillian.energymanagement.repositories.GridAssetRepository;
import com.dillian.energymanagement.repositories.HousingRepository;
import com.dillian.energymanagement.repositories.PublicBuildingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public List<BuildingDTO> findAll() {
        List<BuildingDTO> gridAssets = gridAssetRepository.findAll()
                .stream()
                .map(mapper::toBuildingDto)
                .toList();
        List<BuildingDTO> energySources = energySourceRepository.findAll()
                .stream()
                .map(mapper::toBuildingDto)
                .toList();
        List<BuildingDTO> houseHolds = housingRepository.findAll()
                .stream()
                .map(mapper::toBuildingDto)
                .toList();
        List<BuildingDTO> publicBuildings = publicBuildingRepository.findAll()
                .stream()
                .map(mapper::toBuildingDto)
                .toList();
        return Stream.of(gridAssets, energySources, houseHolds, publicBuildings)
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
    public BuildingDTO findById(Long id) throws Exception {
        List<Optional<? extends Building>> candidateBuildings = List.of(
                energySourceRepository.findById(id),
                housingRepository.findById(id),
                gridAssetRepository.findById(id),
                publicBuildingRepository.findById(id));
        List<? extends Building> foundBuilding = candidateBuildings
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        if (foundBuilding.isEmpty()) {
            throw new Exception("Building not found");
        } else if (foundBuilding.size() > 1) {
            throw new Exception("More than one building with the same id found");
        }

        return foundBuilding.getFirst().toBuildingDTO(mapper);
    }
}
