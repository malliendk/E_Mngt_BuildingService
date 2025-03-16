package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.EventDTO;
import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.mappers.EventMapper;
import com.dillian.energymanagement.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream()
                .map(eventMapper::toDTO)
                .toList();
    }
}
