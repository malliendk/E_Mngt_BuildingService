package com.dillian.energymanagement.bootstrap.building;

import com.dillian.energymanagement.Constants;
import com.dillian.energymanagement.dtos.SolarPanelDTO;
import com.dillian.energymanagement.entities.building.PublicBuilding;
import com.dillian.energymanagement.repositories.PublicBuildingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PublicBuildingBootstrap {

    private final PublicBuildingRepository publicBuildingRepository;

    public List<PublicBuilding> savePublicBuildings() {
        final PublicBuilding townHall = createTownhall();
        final PublicBuilding library = createLibrary();
        final PublicBuilding swimmingPool = createSwimmingPool();
        final PublicBuilding university = createUniversity();
        return publicBuildingRepository.saveAll(List.of(townHall, library, swimmingPool, university));
    }

    private PublicBuilding createTownhall() {
        PublicBuilding townHall = new PublicBuilding();
        townHall.setId(50L);
        townHall.setName("Gemeentehuis");
        townHall.setDescription("Administratief centrum van een gemeente, waar lokale " +
                "overheidsdiensten worden aangeboden en waar gemeentebestuurders " +
                "zoals de burgemeester en wethouders werken");
        townHall.setCategory(Constants.CATEGORY_PUBLIC_BUILDING);
        townHall.setPrice(0);
        townHall.setImageUri("assets/photos/town-hall-outside-cut.png");
        townHall.setSolarPanelCapacity(100);
        townHall.setSolarPanelAmount(100);
        townHall.setSolarPanelSet(new SolarPanelDTO());
        townHall.setEnergyProduction(500);
        townHall.setEnergyConsumption(100);
        townHall.setResearchIncome(0);
        townHall.setPopularityIncome(10);
        townHall.setEnvironmentalScore(100);
        return townHall;
    }

    private PublicBuilding createLibrary() {
        PublicBuilding library = new PublicBuilding();
        library.setId(51L);
        library.setName("Bibliotheek");
        library.setDescription("Openbare instelling waar boeken, tijdschriften, digitale media" +
                " en andere informatiebronnen beschikbaar zijn voor uitleen of studie");
        library.setCategory(Constants.CATEGORY_PUBLIC_BUILDING);
        library.setPrice(400);
        library.setImageUri("assets/photos/bibliotheek.png");
        library.setSolarPanelSet(new SolarPanelDTO());
        library.setSolarPanelCapacity(100);
        library.setSolarPanelAmount(0);
        library.setEnergyConsumption(150);
        library.setResearchIncome(12);
        library.setPopularityIncome(0);
        library.setHousingRequirement(75);
        return library;
    }

    private PublicBuilding createWinkelCentrum() {
        return new PublicBuilding();
    }

    private PublicBuilding createSwimmingPool() {
        PublicBuilding swimmingPool = new PublicBuilding();
        swimmingPool.setId(52L);
        swimmingPool.setName("Zwembad");
        swimmingPool.setDescription("Waterinstallatie voor recreatief of sportief gebruik.");
        swimmingPool.setCategory(Constants.CATEGORY_PUBLIC_BUILDING);
        swimmingPool.setPrice(600);
        swimmingPool.setImageUri("assets/photos/zwembad.jpg");
        swimmingPool.setSolarPanelSet(new SolarPanelDTO());
        swimmingPool.setSolarPanelCapacity(150);
        swimmingPool.setSolarPanelAmount(0);
        swimmingPool.setEnergyConsumption(500);
        swimmingPool.setResearchIncome(0);
        swimmingPool.setPopularityIncome(24);
        swimmingPool.setHousingRequirement(150);
        return swimmingPool;
    }

    private PublicBuilding createUniversity() {
        PublicBuilding university = new PublicBuilding();
        university.setId(53L);
        university.setName("Universiteit");
        university.setDescription("Instelling voor hoger onderwijs en onderzoek, " +
                "waar studenten academische opleidingen volgen en " +
                "wetenschappelijk onderzoek wordt verricht in diverse disciplines");
        university.setCategory(Constants.CATEGORY_PUBLIC_BUILDING);
        university.setImageUri("assets/photos/universiteit.jpg");
        university.setPrice(900);
        university.setSolarPanelSet(new SolarPanelDTO());
        university.setEnergyConsumption(450);
        university.setResearchIncome(50);
        university.setSolarPanelCapacity(200);
        university.setHousingRequirement(400);
        return university;
    }
}
