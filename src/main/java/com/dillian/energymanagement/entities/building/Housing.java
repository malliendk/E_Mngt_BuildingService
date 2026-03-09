package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.entities.BuildingVisitor;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Housing extends Building {

    private int housing;
    private int energyConsumption;
    private int goldIncome;
    private int popularityIncome;
    private int solarPanelCapacity;
    private int solarPanelAmount;

    @Override
    public BuildingDTO accept(BuildingVisitor buildingVisitor) {
        return buildingVisitor.toDTO(this);
    }
}
