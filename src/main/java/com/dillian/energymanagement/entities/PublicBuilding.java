package com.dillian.energymanagement.entities;

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
public class PublicBuilding extends Building {

    private double energyConsumption;
    private int solarPanelCapacity;
    private int researchYield;
    private int popularityYield;
    private int gridLoad;

    @Override
    public BuildingDTO toBuildingDTO(BuildingMapper mapper) {
        return mapper.toBuildingDto(this);
    }
}
