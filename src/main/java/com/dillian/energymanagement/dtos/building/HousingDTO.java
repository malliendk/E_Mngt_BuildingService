package com.dillian.energymanagement.dtos.building;

import com.dillian.energymanagement.dtos.SolarPanelSetDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HousingDTO extends BuildingDTO {

    private Long id;
    private String name;
    private String description;
    private List<SolarPanelSetDTO> solarPanelSets;
    private double energyProduction;
    int price;
    private int houseHolds;
    private double energyConsumption;
    private double popularityYield;
}
