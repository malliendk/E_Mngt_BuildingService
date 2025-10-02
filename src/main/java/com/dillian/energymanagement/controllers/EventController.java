package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.EventDTO;
import com.dillian.energymanagement.schedulers.ScheduledEventService;
import com.dillian.energymanagement.services.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

@RestController()
@RequestMapping("event")
@AllArgsConstructor
@Slf4j
public class EventController {

    private final ScheduledEventService scheduledEventService;
    private final EventService eventService;


    @GetMapping()
    public ResponseEntity<List<EventDTO>> findAll() {
        return ResponseEntity.ok(eventService.findAll());
    }

    /**
     * Endpoint for clients to subscribe to SSE events
     * @return SSE emitter for streaming events
     */

    @GetMapping(value = "stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamEvents() {
        log.info("New client connected to events stream");
        return scheduledEventService.subscribe();
    }

    @PostMapping("stream/pause")
    public String pauseScheduler() {
        scheduledEventService.pauseUpdates();
        return "Event scheduler restarted successfully";
    }

    @PostMapping("/resume")
    public String resumeScheduler() {
        scheduledEventService.resumeUpdates();
        return "Event scheduler restarted successfully";
    }

    /**
     * Optional: Endpoint to manually restart the event scheduler
     */
    @GetMapping("/shutdown")
    public String shutdownScheduler() {
        scheduledEventService.shutdownScheduler();
        return "Event scheduler restarted successfully";
    }
}
