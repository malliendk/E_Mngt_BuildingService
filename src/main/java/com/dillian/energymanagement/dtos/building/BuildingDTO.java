package com.dillian.energymanagement.dtos.building;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingDTO {

    private Long id;
    private String name;
    private String description;
    private int price;
    private String imageUri;
    private double gridCapacityIncrease;
    private double gridLoad;
    private double energyProduction;
    private int houseHolds;
    private double energyConsumption;
    private double popularityYield;
    private int researchYield;
    private int solarPanelAmount;
    private int solarPanelCapacity;
}
