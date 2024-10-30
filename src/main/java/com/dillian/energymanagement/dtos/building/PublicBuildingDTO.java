package com.dillian.energymanagement.dtos.building;

import com.dillian.energymanagement.dtos.SolarPanelSetDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublicBuildingDTO extends BuildingDTO {

    private double gridLoad;
    private double energyConsumption;
    private int researchYield;
    private double popularityYield;
    private List<SolarPanelSetDTO> solarPanelSets;
}
