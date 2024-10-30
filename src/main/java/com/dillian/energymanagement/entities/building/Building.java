package com.dillian.energymanagement.entities.building;

import com.dillian.energymanagement.dtos.building.BuildingDTO;
import com.dillian.energymanagement.mappers.BuildingMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Building {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int price;
    private String imageUri;

    public abstract BuildingDTO toBuildingDTO(BuildingMapper mapper);
}
