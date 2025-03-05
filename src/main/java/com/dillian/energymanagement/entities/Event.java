package com.dillian.energymanagement.entities;

import com.dillian.energymanagement.entities.building.Building;
import com.dillian.energymanagement.entities.building.SpecialBuilding;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    private Long id;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "building_id")
    private SpecialBuilding building;
}
