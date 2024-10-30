package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.EventDTO;
import com.dillian.energymanagement.entities.Event;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class EventMapper {

    public EventDTO toDTO(Event event){
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        dto.setBuildingId(event.getBuilding().getId());
        return dto;
    }
}
