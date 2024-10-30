package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolarPanelSetDTO {

    private double energyProduction;
    private int goldIncome;
    private int researchIncome;
    private int environmentalIncome;
}
