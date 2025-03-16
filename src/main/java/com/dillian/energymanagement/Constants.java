package com.dillian.energymanagement;

public class Constants {

    private Constants() {}

    public static final int SOLAR_PANEL_BASIC_ENERGY_PRODUCTION = 10;
    public static final int SOLAR_PANEL_BASIC_RESEARCH_INCOME = 1;
    public static final int SOLAR_PANEL_BASIC_GOLD_INCOME = 1;
    public static final int SOLAR_PANEL_BASIC_ENVIRONMENTAL_SCORE = 1;

    public static final String CATEGORY_ENERGY_PRODUCTION = "Productie";
    public static final String CATEGORY_GRID_ASSET = "Transport";
    public static final String CATEGORY_PUBLIC_BUILDING = "Openbare voorziening";
    public static final String CATEGORY_INDUSTRIAL = "Industrieel";
    public static final String CATEGORY_HOUSING = "Woning";
    public static final String CATEGORY_POWER_PLANT = "Energiecentrale";
    public static final String CATEGORY_SPECIAL_BUILDING = "Bijzondere voorziening";

    public static final int EVENT_SCHEDULER_OFFSET_SECONDS = 10;
    public static final int EVENT_SCHEDULER_INTERVAL_SECONDS = 60;
}
