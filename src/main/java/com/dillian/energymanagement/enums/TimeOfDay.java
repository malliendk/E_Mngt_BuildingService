package com.dillian.energymanagement.enums;

import lombok.Getter;

@Getter
public enum TimeOfDay {

    MORNING(0.75),
    AFTERNOON(1),
    EVENING(0.25),
    NIGHT(0);

    private final double generationFactor;

    TimeOfDay(double generationFactor) {
        this.generationFactor = generationFactor;
    }
}
