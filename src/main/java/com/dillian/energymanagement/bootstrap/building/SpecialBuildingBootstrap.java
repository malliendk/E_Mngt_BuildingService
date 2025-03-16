package com.dillian.energymanagement.bootstrap.building;


import com.dillian.energymanagement.Constants;
import com.dillian.energymanagement.entities.building.SpecialBuilding;
import com.dillian.energymanagement.repositories.SpecialBuildingsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SpecialBuildingBootstrap {

    private final SpecialBuildingsRepository specialBuildingsRepository;

    public Map<String, SpecialBuilding> saveSpecialBuildings() {
        final SpecialBuilding aquaPark = createAquaPark();
        final SpecialBuilding themePark = createThemePark();
        final SpecialBuilding snowWorld = createSnowWorld();
        final SpecialBuilding shoppingResort = createShoppingResort();
        final SpecialBuilding laboratory = createLaboratory();
        specialBuildingsRepository.saveAll(List.of(aquaPark, themePark, snowWorld, shoppingResort, laboratory));
        return Map.of(
                "aquaPark", aquaPark,
                "themePark", themePark,
                "snowWorld", snowWorld,
                "shoppingResort", shoppingResort,
                "laboratory", laboratory
        );
    }

    private SpecialBuilding createAquaPark() {
        SpecialBuilding aquaPark = new SpecialBuilding();
        aquaPark.setId(60L);
        aquaPark.setName("Tropisch zwemparadijs");
        aquaPark.setDescription("recreatieve zwemlocatie die is ingericht met tropische thema's" );
        aquaPark.setCategory(Constants.CATEGORY_SPECIAL_BUILDING);
        aquaPark.setImageUri("assets/photos/tropisch-zwemparadijs.png");
        aquaPark.setEnergyConsumption(2000);
        aquaPark.setPopularityIncome(60);
        aquaPark.setPopularityCost(1000);
        return aquaPark;
    }

    private SpecialBuilding createThemePark() {
        SpecialBuilding themePark = new SpecialBuilding();
        themePark.setId(61L);
        themePark.setName("Pretpark");
        themePark.setDescription("recreatiepark met diverse attracties, " +
                "zoals achtbanen, draaimolens en waterattracties, ontworpen voor vermaak " +
                "en avontuur voor bezoekers van alle leeftijden.");
        themePark.setCategory(Constants.CATEGORY_SPECIAL_BUILDING);
        themePark.setEnergyConsumption(2000);
        themePark.setGoldIncome(75);
        themePark.setPopularityIncome(80);
        themePark.setPopularityCost(2000);
        return themePark;
    }

    private SpecialBuilding createSnowWorld() {
        SpecialBuilding snowWorld = new SpecialBuilding();
        snowWorld.setId(62L);
        snowWorld.setName("Snow World");
        snowWorld.setDescription("overdekt skigebied of wintersportcentrum, " +
                "waar bezoekers het hele jaar door kunnen skiën, " +
                "snowboarden of andere winteractiviteiten doen,");
        snowWorld.setCategory(Constants.CATEGORY_SPECIAL_BUILDING);
        snowWorld.setEnergyConsumption(2250);
        snowWorld.setGoldIncome(50);
        snowWorld.setPopularityIncome(75);
        snowWorld.setPopularityCost(1750);
        return snowWorld;
    }

    private SpecialBuilding createShoppingResort() {
        SpecialBuilding shoppingResort = new SpecialBuilding();
        shoppingResort.setId(63L);
        shoppingResort.setName("Shopping Resort");
        shoppingResort.setDescription("uitgebreid winkelcentrum dat naast winkels ook andere" +
                " recreatieve voorzieningen biedt, " +
                "zoals restaurants, entertainment, hotels " +
                "en wellnessfaciliteiten,");
        shoppingResort.setCategory(Constants.CATEGORY_SPECIAL_BUILDING);
        shoppingResort.setEnergyConsumption(5000);
        shoppingResort.setGoldIncome(160);
        shoppingResort.setPopularityIncome(135);
        shoppingResort.setPopularityCost(2500);
        return shoppingResort;
    }

    private SpecialBuilding createLaboratory() {
        SpecialBuilding laboratory = new SpecialBuilding();
        laboratory.setId(64L);
        laboratory.setName("Laboratorium");
        laboratory.setDescription("gebouw dat volledig is ingericht voor " +
                "wetenschappelijk onderzoek en laboratoria, waar wetenschappelijk onderzoek wordt" +
                "uitgevoerd met behulp van gespecialiseerde apparatuur en materialen.");
        laboratory.setCategory(Constants.CATEGORY_SPECIAL_BUILDING);
        laboratory.setPopularityCost(2250);
        laboratory.setGoldIncome(120);
        laboratory.setResearchIncome(80);
        laboratory.setEnergyConsumption(3000);
        return laboratory;
    }
}
