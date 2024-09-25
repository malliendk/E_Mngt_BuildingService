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
public class PublicBuilding extends Building {

    private double energyConsumption;
    private int solarPanelCapacity;
    private int researchYield;
    private int popYield;
    private int gridLoad;
}
