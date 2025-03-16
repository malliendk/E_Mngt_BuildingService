package com.dillian.energymanagement.dtos;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {

    @Id
    private Long id;
    private String name;
    private String description;
    private BuildingDTO buildingDTO;
}
