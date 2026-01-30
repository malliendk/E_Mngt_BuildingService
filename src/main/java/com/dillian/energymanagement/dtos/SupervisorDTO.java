package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupervisorDTO {

    private Long id;
    private int instanceId;
    private String name;
    private String imageUrl;
    private String biography;
    private String classType;
    private String type;
    private String specialAbility;
    private int perkGoldIncome;
    private int perkGoldCost;
    private int perkPopularityIncome;
    private int perkPopularityCost;
    private int perkResearchIncome;
    private int perkResearchCost;
    private int perkGridResilience;
    private int perkGridEfficiency;
    private int specialPerk;
}
