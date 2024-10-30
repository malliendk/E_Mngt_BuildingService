package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.SolarPanelSetDTO;
import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Housing extends Building {

    private int houseHolds;
    private double energyConsumption;
    private double popularityYield;

    private List<SolarPanelSetDTO> solarPanelSets;

    @Override
    public BuildingDTO toBuildingDTO(BuildingMapper mapper) {
        return mapper.toBuildingDto(this);
    }
}
