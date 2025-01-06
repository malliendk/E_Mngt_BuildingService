package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Factory extends Building {

    private int energyProduction = 10000;
    private int gridLoad;


    @Override
    public BuildingDTO toBuildingDTO(BuildingMapper mapper) {
        return mapper.toBuildingDTO(this);
    }
}
