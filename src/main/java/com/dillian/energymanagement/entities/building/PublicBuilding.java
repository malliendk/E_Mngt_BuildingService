package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.dtos.SolarPanelDTO;
import com.dillian.energymanagement.entities.BuildingVisitor;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PublicBuilding extends Building {

    private int energyProduction;
    private int energyConsumption;
    private int goldIncome;
    private int researchIncome;
    private int popularityIncome;
    private int solarPanelCapacity;
    private int solarPanelAmount;
    private int environmentalScore;
    @Embedded
    private SolarPanelDTO solarPanelSet;


    @Override
    public BuildingDTO accept(BuildingVisitor buildingVisitor) {
        return buildingVisitor.toDTO(this);
    }
//    @Override
//    public BuildingDTO foundBuildingToDTO(BuildingMapper mapper) {
//        return mapper.publicBuildingToDTO(this);
//    }
}
