package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndustrialBuilding extends Building {

    private int energyConsumption;
    private int goldIncome;
    private int researchIncome;

    @Override
    public BuildingDTO accept(BuildingMapper mapper) {
        return mapper.industrialBuildingToDTO(this);
    }
}
