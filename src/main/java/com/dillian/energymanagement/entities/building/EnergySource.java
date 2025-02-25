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
public class EnergySource extends Building {

    private int energyProduction;
    private int popularityIncome;
    private int environmentalScore;


    @Override
    public BuildingDTO foundBuildingToDTO(BuildingMapper mapper) {
        return mapper.toDTO(this);
    }
}

