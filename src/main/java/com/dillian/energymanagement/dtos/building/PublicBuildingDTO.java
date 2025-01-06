package com.dillian.energymanagement.dtos.building;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicBuildingDTO extends BuildingDTO {

    private double gridLoad;
    private double energyConsumption;
    private int researchYield;
    private double popularityYield;
}
