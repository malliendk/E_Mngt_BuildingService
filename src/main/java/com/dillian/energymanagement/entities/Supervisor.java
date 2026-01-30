package com.dillian.energymanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Supervisor {

    @Id
    private Long id;
    @GeneratedValue
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
