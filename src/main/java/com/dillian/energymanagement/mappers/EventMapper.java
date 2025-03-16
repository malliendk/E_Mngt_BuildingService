package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.BuildingDTO;
import com.dillian.energymanagement.dtos.EventDTO;
import com.dillian.energymanagement.entities.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
public class EventMapper {

    private final BuildingMapperImpl buildingMapper;

    public EventDTO toDTO(Event event){
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        BuildingDTO buildingDTO = event.getBuilding().accept(buildingMapper);
        dto.setBuildingDTO(buildingDTO);
        return dto;
    }
}
