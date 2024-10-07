package com.dillian.energymanagement.dtos.building;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnergySourceDTO extends BuildingDTO{

    private Long id;
    private String name;
    private String description;
    private int price;
    private double gridLoad;
    private double energyProduction;
}

