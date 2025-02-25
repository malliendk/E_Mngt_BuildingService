package com.dillian.energymanagement.dtos;

import com.dillian.energymanagement.Constants;
import lombok.Getter;

@Getter
public class SolarPanelDTO {

    private final int energyProductionExtra = Constants.SOLAR_PANEL_BASIC_ENERGY_PRODUCTION;
    private final int researchIncomeExtra = Constants.SOLAR_PANEL_BASIC_RESEARCH_INCOME;
    private final int goldIncomeExtra = Constants.SOLAR_PANEL_BASIC_GOLD_INCOME;
    private final int environmentalScoreExtra = Constants.SOLAR_PANEL_BASIC_ENVIRONMENTAL_SCORE;
}
