package com.dillian.energymanagement.dtos.building;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HousingDTO extends BuildingDTO {

    private Long id;
    private String name;
    private String description;
    private double energyProduction;
    int price;
    private int houseHolds;
    private double energyConsumption;
    private double popularityYield;
}
