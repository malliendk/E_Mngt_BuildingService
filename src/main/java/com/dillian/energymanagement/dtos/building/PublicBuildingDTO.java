package com.dillian.energymanagement.dtos.building;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublicBuildingDTO extends BuildingDTO {

    private double gridLoad;
    private double energyConsumption;
    private List<Long> solarPanelSetIds;
    private int researchYield;
    private double popularityYield;
}
