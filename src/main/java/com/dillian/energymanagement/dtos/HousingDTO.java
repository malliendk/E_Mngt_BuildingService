package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HousingDTO {

    private Long id;
    private String name;
    private String description;
    int price;
    private int houseHolds;
    private double energyConsumption;
    private double solarPanelCapacity;
    private double popYield;
}
