package com.dillian.energymanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdjacencySet {

    private String buildingName1;
    private String buildingName2;
    private String affectedProperty;
    private int effect;
    private boolean hasAreaEffect;
    private boolean canBeConsumed;
}
