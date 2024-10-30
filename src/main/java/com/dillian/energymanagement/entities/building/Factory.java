package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Factory extends Building{
    @Override
    public BuildingDTO toBuildingDTO(BuildingMapper mapper) {
        return null;
    }
}
