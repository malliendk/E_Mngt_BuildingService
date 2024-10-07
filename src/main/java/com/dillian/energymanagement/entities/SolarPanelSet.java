package com.dillian.energymanagement.entities;

import com.dillian.energymanagement.entities.building.Housing;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SolarPanelSet {

    @Id
    @GeneratedValue
    private Long id;
    private double energyProduction;
    private double researchYield;
    @OneToOne
    private Housing housing;
}
