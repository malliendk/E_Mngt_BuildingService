package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GridAssetDTO {

    private Long id;
    private String name;
    private String description;
    int price;
    private double gridCapacityIncrease;
}
