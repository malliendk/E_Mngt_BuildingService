package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.building.Factory;
import com.dillian.energymanagement.entities.building.PublicBuilding;
import com.dillian.energymanagement.repositories.FactoryRepository;
import com.dillian.energymanagement.repositories.PublicBuildingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BuildingGenerator {

    private final PublicBuildingRepository publicBuildingRepository;
    private final FactoryRepository factoryRepository;

    public void createPublicBuildings() {
        PublicBuilding townHall = new PublicBuilding();
        townHall.setId(1L);
        townHall.setName("Town Hall");
        townHall.setDescription("Town Hall");
        townHall.setPrice(0);
        townHall.setImageUri("url");
        townHall.setSolarPanelCapacity(100);
        townHall.setSolarPanelAmount(100);
        publicBuildingRepository.saveAll(List.of(townHall));
    }

    public void createFactories() {
        Factory coalPlant = new Factory();
        coalPlant.setId(2L);
        coalPlant.setName("Coal Plant");
        coalPlant.setDescription("Coal Plant");
        coalPlant.setPrice(0);
        coalPlant.setImageUri("url");
        coalPlant.setEnergyProduction(10000);
        factoryRepository.saveAll(List.of(coalPlant));
    }

//    public List<Building> createWithBasicProperties() {
//        Building kolenCentrale = new Building("kolencentrale", "energievoorziening" +
//                " waar elektriciteit wordt opgewekt op basis van steenkool", 2.5, 0);
//        Building aardgasCentrale = new Building("aardgascentrale", "energievoorziening waar electriciteit " +
//                "wordt opgewekt door aardgas te stoken", 2.5, 0);
//        Building parkeergarage = new Building(, "parkeergarage bestemd" +
//                "voor elektrische voertuigen", 0.5, 1500);
//        Building windPark = new Building(Constants.SOURCE_WINDPARK_NAME, "een groot aantal windturbines " +
//                "op het vaste land", 1.0, 2000);
//        Building windParkOpZee = new Building(Constants.SOURCE_WINDPARKOPZEE_NAME, "een groot aantal windturbines " +
//                "geplaatst in de zee", 1.5, 3000);
//        Building zonneveld = new Building(Constants.SOURCE_ZONNEWEIDE_NAME, "een groot aantal zonnepanelen bij" +
//                " elkaar, gelegen in een weiland", 0.5, 150);
//        Building industrieterrein = new Building(Constants.SOURCE_INDUSTRIETERREIN_NAME, "een verzameling van bedrijfspanden en kleine" +
//                "industrie op een daarvoor bestemd terrein", 1.0, 2000);
//        final List<Building> buildings = List.of(kolenCentrale, aardgasCentrale, parkeergarage, windPark, windParkOpZee,
//                zonneveld, industrieterrein);
//        return service.saveAllInternal(buildings);
//    }
}
