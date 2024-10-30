package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {

    Long id;
    String name;
    String description;
    Long buildingId;
}
