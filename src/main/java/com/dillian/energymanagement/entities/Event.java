package com.dillian.energymanagement.entities;

import com.dillian.energymanagement.entities.building.SpecialBuilding;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
