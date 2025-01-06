package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.building.BuildingDTO;
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
public class Housing extends Building {

    private int houseHolds;
    private double energyConsumption;
    private double popularityYield;
    private int solarPanelCapacity;
    private int solarPanelAmount;

    @Override
    public BuildingDTO toBuildingDTO(BuildingMapper mapper) {
        return mapper.toBuildingDTO(this);
    }
}
