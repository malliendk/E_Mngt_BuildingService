package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.BuildingDTO;
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

    private int energyConsumption;
    private int goldIncome;
    private int researchIncome;

    @Override
    public BuildingDTO foundBuildingToDTO(BuildingMapper mapper) {
        return null;
    }
}
