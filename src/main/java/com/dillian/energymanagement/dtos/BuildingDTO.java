package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingDTO {

    private Long id;
    private Long instanceId;
    private String name;
    private String description;
    private int price;
    private String imageUri;
    private String category;
    private int gridCapacity;
    private int energyConsumption;
    private int energyProduction;
    private int housing;
    private int goldIncome;
    private int popularityIncome;
    private int researchIncome;
    private int popularityCost;
    private int environmentalScore;
    private int housingRequirement;
    private boolean canBePurchased;
}
