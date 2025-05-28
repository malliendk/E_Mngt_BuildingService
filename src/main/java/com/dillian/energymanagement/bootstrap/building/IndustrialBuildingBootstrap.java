package com.dillian.energymanagement.bootstrap.building;

import com.dillian.energymanagement.Constants;
import com.dillian.energymanagement.entities.building.IndustrialBuilding;
import com.dillian.energymanagement.repositories.IndustrialBuildingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class IndustrialBuildingBootstrap {

    private final IndustrialBuildingRepository industrialBuildingRepository;

    public void saveIndustrialBuildings() {
        final IndustrialBuilding electricParkingLot = createElectricParkingLot();
        final IndustrialBuilding industrialArea = createIndustrialArea();
        final IndustrialBuilding officeBuilding = createOfficeBuilding();
        industrialBuildingRepository.saveAll(List.of(electricParkingLot, industrialArea, officeBuilding));
    }

    private IndustrialBuilding createElectricParkingLot() {
        IndustrialBuilding parkeergarage = new IndustrialBuilding();
        parkeergarage.setId(30L);
        parkeergarage.setName("Parkeergarage");
        parkeergarage.setDescription("Parkeergarage bestemd voor elektrische voertuigen");
        parkeergarage.setCategory(Constants.CATEGORY_INDUSTRIAL);
        parkeergarage.setImageUri("assets/photos/electric_parking_lot.png");
        parkeergarage.setPrice(250);
        parkeergarage.setEnergyConsumption(800);
        parkeergarage.setGoldIncome(18);
        return parkeergarage;
    }

    private IndustrialBuilding createOfficeBuilding() {
        IndustrialBuilding officeBuilding = new IndustrialBuilding();
        officeBuilding.setId(31L);
        officeBuilding.setName("Kantoorcomplex");
        officeBuilding.setDescription("Groep van gebouwen met meerdere kantoorruimtes, bedoeld voor bedrijven, " +
                "organisaties en andere zakelijke activiteiten.");
        officeBuilding.setCategory(Constants.CATEGORY_INDUSTRIAL);
        officeBuilding.setPrice(400);
        officeBuilding.setEnergyConsumption(1000);
        officeBuilding.setGoldIncome(30);
        return officeBuilding;
    }

    private IndustrialBuilding createIndustrialArea() {
        IndustrialBuilding industrialArea = new IndustrialBuilding();
        industrialArea.setId(32L);
        industrialArea.setName("Industrieterrein");
        industrialArea.setDescription("speciaal aangewezen gebied waar bedrijven en fabrieken zijn gevestigd," +
                " gericht op productie, opslag, logistiek en andere industriële activiteiten.");
        industrialArea.setCategory(Constants.CATEGORY_INDUSTRIAL);
        industrialArea.setImageUri("assets/photos/industrie_terrein.png");
        industrialArea.setPrice(750);
        industrialArea.setEnergyConsumption(1350);
        industrialArea.setGoldIncome(56);
        log.info("industrial area created with id: " + industrialArea.getId());
        return industrialArea;
    }
}
