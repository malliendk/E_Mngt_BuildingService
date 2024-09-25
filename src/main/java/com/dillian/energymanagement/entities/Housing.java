package com.dillian.energymanagement.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Housing extends Building {

    private int houseHolds;
    private double energyConsumption;
    private double solarPanelCapacity;
    private double popYield;
}
