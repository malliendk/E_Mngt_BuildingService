package com.dillian.energymanagement.schedulers;

import com.dillian.energymanagement.Constants;
import com.dillian.energymanagement.dtos.EventDTO;
import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.mappers.EventMapper;
import com.dillian.energymanagement.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ScheduledEventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    private ScheduledExecutorService scheduler;
    private List<Event> initialEvents;

    public ScheduledEventService(final EventRepository eventRepository, final EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        startScheduler();
    }

    @EventListener(ApplicationReadyEvent.class)
    private void getInitialEvents() {
        this.initialEvents = eventRepository.findAll();
    }

    /**
     * Shuts down the current scheduler if it exists
     */
    /**
     * Shuts down the current scheduler if it exists
     */
    public synchronized void shutdownScheduler() {
        if (scheduler != null && !scheduler.isShutdown()) {
            try {
                scheduler.shutdown();
                if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                }
                log.info("Game event scheduler has been shut down");
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
                Thread.currentThread().interrupt();
                log.error("Interrupted while shutting down scheduler", e);
            }
        }
    }

    /**
     * Starts a new scheduler after shutting down any existing one
     */
    public synchronized void startScheduler() {
        shutdownScheduler();
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::sendGameUpdates,
                Constants.EVENT_SCHEDULER_OFFSET_SECONDS,
                Constants.EVENT_SCHEDULER_INTERVAL_SECONDS,
                TimeUnit.SECONDS);
        log.info("Game event scheduler has been started");
    }

    /**
     * Registers a new SSE emitter for a client connection
     * @return SseEmitter for the client
     */
    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        emitter.onCompletion(() -> {
            emitters.remove(emitter);
            log.info("SSE connection closed. Total active connections: {}", emitters.size());
        });
        emitter.onTimeout(() -> {
            emitter.complete();
            emitters.remove(emitter);
            log.info("SSE connection timed out. Total active connections: {}", emitters.size());
        });
        emitter.onError(ex -> {
            emitter.completeWithError(ex);
            emitters.remove(emitter);
            log.error("SSE error: {}", ex.getMessage());
        });

        try {
            final EventDTO eventDTO = selectRandomEvent();
            emitDTO(emitter, eventDTO);
            log.info("Initial game data successfully sent to client");
        } catch (IOException e) {
            emitter.completeWithError(e);
            return emitter;
        }

        emitters.add(emitter);
        log.info("New SSE connection established. Total active connections: {}", emitters.size());

        return emitter;
    }

    /**
     * Sends game updates to all connected clients
     */
    private void sendGameUpdates() {
        if (emitters.isEmpty()) {
            return;
        }
        List<SseEmitter> deadEmitters = new ArrayList<>();
        emitters.forEach(emitter -> {
            try {
                final EventDTO eventDTO = selectRandomEvent();
                emitDTO(emitter, eventDTO);
                log.debug("Successfully sent game update to client");
            } catch (IOException e) {
                deadEmitters.add(emitter);
                log.error("Failed to send game update to client: {}", e.getMessage());
            }
        });
        if (!deadEmitters.isEmpty()) {
            emitters.removeAll(deadEmitters);
            log.info("Removed {} dead connections. Total active connections: {}",
                    deadEmitters.size(), emitters.size());
        }
        log.debug("Game update sent to {} clients", emitters.size());
    }

    private static void emitDTO(final SseEmitter emitter, final EventDTO eventDTO) throws IOException {
        emitter.send(SseEmitter.event()
                .name("game-update")
                .data(eventDTO));
    }

    private EventDTO selectRandomEvent() {
        if (this.initialEvents.isEmpty()) {
            shutdownScheduler();
        }
        int randomIndex = new Random().nextInt(this.initialEvents.size());
        Event selectedEvent = this.initialEvents.get(randomIndex);
        this.initialEvents.remove(selectedEvent);
        return eventMapper.toDTO(selectedEvent);
    }
}
