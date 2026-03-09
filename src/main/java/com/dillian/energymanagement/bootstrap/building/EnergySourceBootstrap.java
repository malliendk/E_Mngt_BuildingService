package com.dillian.energymanagement.bootstrap.building;

import com.dillian.energymanagement.Constants;
import com.dillian.energymanagement.entities.building.EnergySource;
import com.dillian.energymanagement.repositories.EnergySourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnergySourceBootstrap {

    private final EnergySourceRepository energySourceRepository;

    public void saveEnergySources() {
        final EnergySource zonneWeide = createSolarField();
        final EnergySource windMolenPark = createWindMolenPark();
        final EnergySource windParkOpZee = createWindParkOpZee();
        energySourceRepository.saveAll(List.of(zonneWeide, windMolenPark, windParkOpZee));
    }

    private EnergySource createSolarField() {
        EnergySource zonneWeide = new EnergySource();
        zonneWeide.setId(1L);
        zonneWeide.setName("Solar Field");
        zonneWeide.setDescription("Een grootschalig zonnepark op land dat " +
                "duurzame elektriciteit opwekt met zonnepanelen");
        zonneWeide.setImageUri("assets/photos/solar_field.png");
        zonneWeide.setCategory(Constants.CATEGORY_ENERGY_PRODUCTION);
        zonneWeide.setEnergyProduction(400);
        zonneWeide.setPrice(300);
        zonneWeide.setCanBePurchased(true);
        return zonneWeide;
    }

    private EnergySource createWindMolenPark() {
        EnergySource windMolenPark = new EnergySource();
        windMolenPark.setId(2L);
        windMolenPark.setName("Wind Turbine");
        windMolenPark.setDescription("Een groep windturbines die windenergie " +
                "omzetten in elektriciteit");
        windMolenPark.setCategory(Constants.CATEGORY_ENERGY_PRODUCTION);
        windMolenPark.setImageUri("assets/photos/wind_park_2.png");
        windMolenPark.setEnergyProduction(750);
        windMolenPark.setPrice(600);
        windMolenPark.setCanBePurchased(true);
        return windMolenPark;
    }

    private EnergySource createWindParkOpZee() {
        EnergySource windParkOpZee = new EnergySource();
        windParkOpZee.setId(3L);
        windParkOpZee.setName("Sea-side Wind Turbine");
        windParkOpZee.setDescription("Een groep windturbines in open water " +
                "die windenergie omzetten in elektriciteit");
        windParkOpZee.setCategory(Constants.CATEGORY_ENERGY_PRODUCTION);
        windParkOpZee.setImageUri("assets/photos/windpark_op_zee.png");
        windParkOpZee.setEnvironmentalScore(0);
        windParkOpZee.setEnergyProduction(1150);
        windParkOpZee.setPrice(750);
        windParkOpZee.setCanBePurchased(true);
        return windParkOpZee;
    }
}
