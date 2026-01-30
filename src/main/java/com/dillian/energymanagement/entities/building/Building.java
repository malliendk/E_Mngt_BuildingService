package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.entities.BuildingVisitor;
import jakarta.persistence.Entity;
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
public abstract class Building {

    @Id
    private Long id;
    private String name;
    private String description;
    private int price;
    private String imageUri;
    private String category;
    private boolean canBePurchased;

    public abstract BuildingDTO accept(BuildingVisitor buildingVisitor);
}
