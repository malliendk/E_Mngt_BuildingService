package com.dillian.energymanagement.services;

import com.dillian.energymanagement.enums.TimeOfDay;
import com.dillian.energymanagement.enums.WeatherType;
import lombok.Getter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Getter
public class WeatherService {

    private List<TimeOfDay> timesOfDay;
    private List<WeatherType> weatherTypes;

    @EventListener(ApplicationReadyEvent.class)
    public void loadTimesOfDay() {
         this.timesOfDay = List.of(
                TimeOfDay.MORNING,
                TimeOfDay.AFTERNOON,
                TimeOfDay.EVENING,
                TimeOfDay.NIGHT);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void loadWeatherTypes() {
        this.weatherTypes = List.of(
                WeatherType.SUNNY,
                WeatherType.MODERATE,
                WeatherType.OVERCAST,
                WeatherType.RAINY);
    }

    public Map<TimeOfDay, WeatherType> createNewDayWeatherMap() {
        WeatherType randomWeatherType = this.weatherTypes.get(getRandomIndex());
        return this.timesOfDay.stream()
                .collect(Collectors.toMap(timeOfDay -> timeOfDay, weatherType -> randomWeatherType));
    }

    private int getRandomIndex() {
        return new Random().nextInt(0,4);
    }
}
