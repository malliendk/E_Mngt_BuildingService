package com.dillian.energymanagement.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BuildingInGame {

    private Long id;
    private String name;
    private boolean canBePurchased;
    private String category;
    private String description;
    private int price;
    private String imageUri;
    private int gridCapacity;
    private int energyConsumption;
    private int energyProduction;
    private int housing;
    private int goldIncome;
    private int popularityIncome;
    private int researchIncome;
    private int environmentalScore;
    private int housingRequirement;
    private int popularityCost;
    private int solarPanelAmount;
    private int solarPanelCapacity;
}
