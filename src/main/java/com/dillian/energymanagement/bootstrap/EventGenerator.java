package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.entities.building.SpecialBuilding;
import com.dillian.energymanagement.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventGenerator {

    private final EventRepository eventRepository;

    public Event createThemeParkEvent(SpecialBuilding themePark) {
        Event themeParkEvent = new Event();
        themeParkEvent.setId(1L);
        themeParkEvent.setName("Bouw van een pretpark");
        themeParkEvent.setDescription("Een exploitant wil een pretpark bouwen aan de rand van je gemeente. " +
                "Volgens de verstrekte onderzoeken is er onder je inwoners veel behoefte aan een pretpark .");
        themeParkEvent.setBuilding(themePark);
        return themeParkEvent;
    }

    public Event createEventAquaPark(SpecialBuilding aquaPark) {
        Event aquaParkEvent = new Event();
        aquaParkEvent.setId(2L);
        aquaParkEvent.setName("Bouw van een tropisch zwemparadijs");
        aquaParkEvent.setDescription("Een investeerder heeft plannen om een tropisch zwemparadijs te bouwen in je gemeente. " +
                "Er is al langer vraag naar een grote zwemgelegenheid.");
        aquaParkEvent.setBuilding(aquaPark);
        return aquaParkEvent;
    }

    public Event createEventShoppingResort(SpecialBuilding shoppingResort) {
        Event shoppingResortEvent = new Event();
        shoppingResortEvent.setId(3L);
        shoppingResortEvent.setName("Aanleg van een shopping resort");
        shoppingResortEvent.setDescription("Een ontwikkelaar wil een groot shopping resort realiseren een eind buiten je stad. " +
                "Je inwoners zijn laaiend enthousiast en er wordt in de wijde omtrek reikhalzend uitgekeken naar de start van het" +
                "project.");
        shoppingResortEvent.setBuilding(shoppingResort);
        return shoppingResortEvent;
    }

    public Event createEventLaboratory(SpecialBuilding laboratory) {
        Event laboratoryEvent = new Event();
        laboratoryEvent.setId(4L);
        laboratoryEvent.setName("Bouw van een laboratorium");
        laboratoryEvent.setDescription("Een organisatie heeft plannen om een geavanceerd onderzoekslaboratorium op te " +
                "zetten aan de rand van de gemeente. Dit centrum zal bijdragen aan wetenschappelijke vooruitgang " +
                "en nieuwe innovaties.");
        laboratoryEvent.setBuilding(laboratory);
        return laboratoryEvent;
    }

    public Event createEventSnowWorld(SpecialBuilding laboratory) {
        Event snowWorldEvent = new Event();
        snowWorldEvent.setId(5L);
        snowWorldEvent.setName("Bouw van een snow world");
        snowWorldEvent.setDescription("Een ondernemer wil een grootschalige Snow World vestigen aan de rand van de " +
                "gemeente. Dit biedt inwoners en bezoekers het hele jaar door de mogelijkheid om te skiën en snowboarden.");
        snowWorldEvent.setBuilding(laboratory);
        return snowWorldEvent;
    }
}
