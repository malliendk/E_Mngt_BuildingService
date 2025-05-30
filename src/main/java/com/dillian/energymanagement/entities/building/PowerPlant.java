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
public class PowerPlant extends Building {

    private int energyProduction;
    private int gridLoad;

    @Override
    public BuildingDTO accept(BuildingVisitor buildingVisitor) {
        return buildingVisitor.toDTO(this);
    }

//    @Override
//    public BuildingDTO foundBuildingToDTO(BuildingMapper mapper) {
//        return mapper.publicBuildingToDTO(this);
//    }
}
