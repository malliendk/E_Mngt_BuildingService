package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.bootstrap.building.SpecialBuildingBootstrap;
import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.entities.building.SpecialBuilding;
import com.dillian.energymanagement.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventBootstrap {

    private final EventRepository eventRepository;
    private final SpecialBuildingBootstrap specialBuildingBootstrap;

    public Event createThemeParkEvent(SpecialBuilding themePark) {
        Event themeParkEvent = new Event();
        themeParkEvent.setId(1L);
        themeParkEvent.setName("Bouw van een pretpark");
        themeParkEvent.setDescription("Een exploitant wil een pretpark bouwen. " +
                "Volgens de verstrekte onderzoeken is er onder je inwoners veel behoefte aan een pretpark .");
        themeParkEvent.setBuilding(themePark);
        return themeParkEvent;
    }

    public Event createAquaParkEvent(SpecialBuilding aquaPark) {
        Event aquaParkEvent = new Event();
        aquaParkEvent.setId(2L);
        aquaParkEvent.setName("Bouw van een tropisch zwemparadijs");
        aquaParkEvent.setDescription("Een investeerder heeft plannen om een tropisch zwemparadijs te bouwen in je gemeente. " +
                "Er is al langer vraag naar een grote zwemgelegenheid.");
        aquaParkEvent.setBuilding(aquaPark);
        return aquaParkEvent;
    }

    public Event createShoppingResortEvent(SpecialBuilding shoppingResort) {
        Event shoppingResortEvent = new Event();
        shoppingResortEvent.setId(3L);
        shoppingResortEvent.setName("Aanleg van een shopping resort");
        shoppingResortEvent.setDescription("Een ondernemerscollectief wil een groot shopping resort bouwen. " +
                "Er wordt in de wijde omtrek reikhalzend uitgekeken naar de realisatie van het" +
                "project.");
        shoppingResortEvent.setBuilding(shoppingResort);
        return shoppingResortEvent;
    }

    public Event createLaboratoryEvent(SpecialBuilding laboratory) {
        Event laboratoryEvent = new Event();
        laboratoryEvent.setId(4L);
        laboratoryEvent.setName("Bouw van een laboratorium");
        laboratoryEvent.setDescription("Een organisatie heeft plannen om een geavanceerd onderzoekslaboratorium op te " +
                "zetten. Dit centrum zal bijdragen aan wetenschappelijke vooruitgang " +
                "en nieuwe innovaties.");
        laboratoryEvent.setBuilding(laboratory);
        return laboratoryEvent;
    }

    public Event createSnowWorldEvent(SpecialBuilding snowWorld) {
        Event snowWorldEvent = new Event();
        snowWorldEvent.setId(5L);
        snowWorldEvent.setName("Bouw van een snow world");
        snowWorldEvent.setDescription("Een ondernemer wil een grootschalige Snow World vestigen aan de rand van de " +
                "gemeente. Dit biedt inwoners en bezoekers het hele jaar door de mogelijkheid om te skiën en snowboarden.");
        snowWorldEvent.setBuilding(snowWorld);
        return snowWorldEvent;
    }

    public Event purchaseSolarPanelsVrijstaandHuis() {
        return new Event();
    }

    public Event purchaseSolarPanelsTweeOnderEenKap() {
        return new Event();
    }

    public Event purchaseSolarPanelsHuizenrij() {
        return new Event();
    }

    public Event purchaseSolarPanelsAppartementencomplex() {
        return new Event();
    }
    //aanleggen snelweg
}
