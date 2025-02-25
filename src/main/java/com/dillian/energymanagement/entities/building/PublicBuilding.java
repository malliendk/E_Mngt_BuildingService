package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.dtos.SolarPanelDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class PublicBuilding extends Building {

    private int energyConsumption;
    private int researchIncome;
    private int popularityIncome;
    private int solarPanelCapacity;
    private int solarPanelAmount;
    @Embedded
    private SolarPanelDTO solarPanelSet;


    @Override
    public BuildingDTO foundBuildingToDTO(BuildingMapper mapper) {
        return mapper.toDTO(this);
    }
}
