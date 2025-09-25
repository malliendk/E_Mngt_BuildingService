package com.dillian.energymanagement.bootstrap.building;

import com.dillian.energymanagement.Constants;
import com.dillian.energymanagement.dtos.SolarPanelDTO;
import com.dillian.energymanagement.entities.building.Housing;
import com.dillian.energymanagement.repositories.HousingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HousingBootstrap {

    private HousingRepository housingRepository;

    public void saveHousingBuildings() {
        final Housing vrijstaandHuis = createVrijstaandHuis();
        final Housing tweeOnderEenKap = createTweeOnderEenKap();
        final Housing apartmentBuilding = createApartmentBuilding();
        final Housing huizenRij = createHuizenRij();
        housingRepository.saveAll(List.of(vrijstaandHuis, tweeOnderEenKap, apartmentBuilding, huizenRij));
    }

    private Housing createVrijstaandHuis() {
        Housing vrijstaandHuis = new Housing();
        vrijstaandHuis.setId(20L);
        vrijstaandHuis.setName("Vrijstaand huis");
        vrijstaandHuis.setDescription("Woning die volledig vrijstaat van aangrenzende gebouwen,");
        vrijstaandHuis.setCategory(Constants.CATEGORY_HOUSING);
        vrijstaandHuis.setPrice(100);
        vrijstaandHuis.setImageUri("assets/photos/vrijstaand-huis.jpg");
        vrijstaandHuis.setEnergyConsumption(100);
        vrijstaandHuis.setHouseHolds(1);
        vrijstaandHuis.setGoldIncome(0);
        vrijstaandHuis.setPopularityIncome(5);
        vrijstaandHuis.setSolarPanelCapacity(15);
        vrijstaandHuis.setSolarPanelSet(new SolarPanelDTO());
        return vrijstaandHuis;
    }

    private Housing createTweeOnderEenKap() {
        Housing tweeOnderEenKap = new Housing();
        tweeOnderEenKap.setId(21L);
        tweeOnderEenKap.setName("Twee onder één kap");
        tweeOnderEenKap.setDescription("Dubbelhuis waarbij twee afzonderlijke woningen met " +
                "een gedeelde tussenmuur één bouwstructuur vormen,");
        tweeOnderEenKap.setCategory(Constants.CATEGORY_HOUSING);
        tweeOnderEenKap.setPrice(150);
        tweeOnderEenKap.setEnergyConsumption(175);
        tweeOnderEenKap.setHouseHolds(2);
        tweeOnderEenKap.setGoldIncome(0);
        tweeOnderEenKap.setPopularityIncome(2);
        tweeOnderEenKap.setSolarPanelCapacity(20);
        tweeOnderEenKap.setSolarPanelSet(new SolarPanelDTO());
        return tweeOnderEenKap;
    }

    private Housing createApartmentBuilding() {
        Housing apartmentBuilding = new Housing();
        apartmentBuilding.setId(22L);
        apartmentBuilding.setName("Apparementencomplex");
        apartmentBuilding.setDescription("Gebouw met meerdere zelfstandige wooneenheden");
        apartmentBuilding.setCategory(Constants.CATEGORY_HOUSING);
        apartmentBuilding.setPrice(1250);
        apartmentBuilding.setEnergyConsumption(1625);
        apartmentBuilding.setHouseHolds(25);
        apartmentBuilding.setSolarPanelCapacity(15);
        apartmentBuilding.setSolarPanelSet(new SolarPanelDTO());
        return apartmentBuilding;
    }

    private Housing createHuizenRij() {
        Housing huizenRij = new Housing();
        huizenRij.setId(23L);
        huizenRij.setName("Huizenrij");
        huizenRij.setDescription("Aaneengesloten reeks van meerdere identieke of vergelijkbare " +
                "woningen die een gemeenschappelijke zijmuren delen");
        huizenRij.setCategory(Constants.CATEGORY_HOUSING);
        huizenRij.setPrice(750);
        huizenRij.setEnergyConsumption(800);
        huizenRij.setHouseHolds(10);
        huizenRij.setSolarPanelSet(new SolarPanelDTO());
        huizenRij.setSolarPanelCapacity(10);
        return huizenRij;
    }
}
