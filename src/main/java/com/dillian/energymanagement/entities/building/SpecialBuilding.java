package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.entities.BuildingVisitor;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SpecialBuilding extends Building {

    private int goldCost;
    private int popularityCost;
    private int energyConsumption;
    private int goldIncome;
    private int researchIncome;
    private int popularityIncome;

    @Override
    public BuildingDTO accept(BuildingVisitor buildingVisitor) {
        return buildingVisitor.toDTO(this);
    }
}
