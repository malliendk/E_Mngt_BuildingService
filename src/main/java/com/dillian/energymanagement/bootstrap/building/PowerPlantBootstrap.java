package com.dillian.energymanagement.bootstrap.building;

import com.dillian.energymanagement.Constants;
import com.dillian.energymanagement.entities.building.PowerPlant;
import com.dillian.energymanagement.repositories.PowerPlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PowerPlantBootstrap {

    private final PowerPlantRepository powerPlantRepository;

    public void savePowerPlants() {
        final PowerPlant coalPlant = createCoalPlant();
        final PowerPlant gasPlant = createGasPlant();
        final PowerPlant hydrogenPlant = createHydrogenPlant();
        final PowerPlant nuclearPlant = createNuclearPlant();
        powerPlantRepository.saveAll(List.of(coalPlant, gasPlant, hydrogenPlant, nuclearPlant));
    }

    private PowerPlant createCoalPlant() {
        PowerPlant coalPlant = new PowerPlant();
        coalPlant.setId(40L);
        coalPlant.setName("Kolencentrale");
        coalPlant.setDescription("Energievoorziening waar elektriciteit wordt opgewekt" +
                " door middel van steenkool");
        coalPlant.setCategory(Constants.CATEGORY_POWER_PLANT);
        coalPlant.setPrice(0);
        coalPlant.setImageUri("assets/photos/coal_plant.png");
        coalPlant.setEnergyProduction(5000);
        return coalPlant;
    }

    private PowerPlant createGasPlant() {
        PowerPlant gasPlant = new PowerPlant();
        gasPlant.setId(41L);
        gasPlant.setName("Gascentrale");
        gasPlant.setDescription("Energievoorziening waar elektriciteit wordt opgewekt " +
                "door middel van gas");
        gasPlant.setCategory(Constants.CATEGORY_POWER_PLANT);
        gasPlant.setPrice(0);
        gasPlant.setImageUri("assets/photos/gas_plant.png");
        gasPlant.setEnergyProduction(5000);
        return gasPlant;
    }

    private PowerPlant createHydrogenPlant() {
        PowerPlant hydrogenPlant = new PowerPlant();
        hydrogenPlant.setId(42L);
        hydrogenPlant.setName("Waterstofcentrale");
        hydrogenPlant.setDescription("Energiecentrale die waterstof als brandstof " +
                "gebruikt om elektriciteit op te wekken en die vaste waterstof produceert" +
                "als brandstof voor mobiele voertuigen");
        hydrogenPlant.setCategory(Constants.CATEGORY_POWER_PLANT);
        return hydrogenPlant;
    }

    private PowerPlant createNuclearPlant() {
        PowerPlant nuclearPlant = new PowerPlant();
        nuclearPlant.setId(43L);
        nuclearPlant.setName("Kerncentrale");
        nuclearPlant.setDescription("Energiecentrale die elektriciteit opwekt door kernsplijting of kernfusie");
        nuclearPlant.setCategory(Constants.CATEGORY_POWER_PLANT);
        return nuclearPlant;
    }
}
