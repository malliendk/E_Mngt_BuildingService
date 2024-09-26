package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HousingDTO extends BuildingDTO {

    private Long id;
    private String name;
    private String description;
    int price;
    private int houseHolds;
    private double energyConsumption;
    private int solarPanelCapacity;
    private double popularityYield;
}
