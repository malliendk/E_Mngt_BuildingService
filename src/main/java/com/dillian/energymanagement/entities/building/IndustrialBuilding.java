package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IndustrialBuilding extends Building {

    private double energyConsumption;
    private double goldYield;

    @Override
    public BuildingDTO toBuildingDTO(BuildingMapper mapper) {
        return null;
    }
}
