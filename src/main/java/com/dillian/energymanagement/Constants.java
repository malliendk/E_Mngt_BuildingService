package com.dillian.energymanagement;

public class Constants {

    private Constants() {}

    public static final int SOLAR_PANEL_BASIC_ENERGY_PRODUCTION = 5;
    public static final int SOLAR_PANEL_BASIC_RESEARCH_INCOME = 1;
    public static final int SOLAR_PANEL_BASIC_GOLD_INCOME = 1;
    public static final int SOLAR_PANEL_BASIC_ENVIRONMENTAL_SCORE = 1;

    public static final String CATEGORY_ENERGY_PRODUCTION = "Energy production";
    public static final String CATEGORY_GRID_ASSET = "Energy Transport";
    public static final String CATEGORY_PUBLIC_BUILDING = "Public Facility";
    public static final String CATEGORY_COMMERCIAL = "Commercial";
    public static final String CATEGORY_HOUSING = "Housing";
    public static final String CATEGORY_POWER_PLANT = "Power Plant";
    public static final String CATEGORY_CITY_HIGHLIGHT = "City Highlight";

    public static final int EVENT_SCHEDULER_OFFSET_SECONDS = 300;
    public static final int EVENT_SCHEDULER_INTERVAL_SECONDS = 300;

    public static final String CALCULATION_SERVICE_SAVE_URL = "http://localhost:8093/save-game";
}
