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
public class Housing extends Building {

    private int houseHolds;
    private double energyConsumption;
    private int solarPanelCapacity;
    private double popularityYield;

    @Override
    public BuildingDTO toBuildingDTO(BuildingMapper mapper) {
        return mapper.toBuildingDto(this);
    }
}
