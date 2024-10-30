package com.dillian.energymanagement.dtos.building;

import com.dillian.energymanagement.dtos.SolarPanelSetDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private List<SolarPanelSetDTO> solarPanelSets;
    private double popularityYield;
    private int researchYield;
}
