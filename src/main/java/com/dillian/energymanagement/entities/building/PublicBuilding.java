package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PublicBuilding extends Building {

    private double energyConsumption;
    private int researchYield;
    private int popularityYield;
    private int gridLoad;
    private int solarPanelCapacity;
    private int solarPanelNumber;

    @Override
    public BuildingDTO toBuildingDTO(BuildingMapper mapper) {
        return mapper.toBuildingDto(this);
    }
}
