package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicBuildingDTO {

    private Long id;
    private String name;
    private String description;
    private int price;
    private int gridLoad;
    private double energyConsumption;
    private int solarPanelCapacity;
    private int researchYield;
    private int popYield;
}
