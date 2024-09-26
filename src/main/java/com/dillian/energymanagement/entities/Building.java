package com.dillian.energymanagement.entities;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class Building {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int price;
    private String imageUri;

    public Building(String name, String description, int price, String imageUri) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUri = imageUri;
    }

    public abstract BuildingDTO toBuildingDTO(BuildingMapper mapper); ;
}
