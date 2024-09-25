package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnergySourceDTO {

    private Long id;
    private String name;
    private String description;
    private int price;
    private double gridLoad;
    private double energyProduction;
}

