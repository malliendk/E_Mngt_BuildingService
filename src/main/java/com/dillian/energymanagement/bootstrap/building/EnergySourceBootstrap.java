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
        final EnergySource zonneWeide = createZonneWeide();
        final EnergySource windMolenPark = createWindMolenPark();
        final EnergySource windParkOpZee = createWindParkOpZee();
        energySourceRepository.saveAll(List.of(zonneWeide, windMolenPark, windParkOpZee));
    }

    private EnergySource createZonneWeide() {
        EnergySource zonneWeide = new EnergySource();
        zonneWeide.setId(1L);
        zonneWeide.setName("Zonneweide");
        zonneWeide.setDescription("Een grootschalig zonnepark op land dat " +
                "duurzame elektriciteit opwekt met zonnepanelen");
        zonneWeide.setImageUri("assets/photos/solar_field.png");
        zonneWeide.setCategory(Constants.CATEGORY_ENERGY_PRODUCTION);
        zonneWeide.setEnergyProduction(275);
        return zonneWeide;
    }

    private EnergySource createWindMolenPark() {
        EnergySource windMolenPark = new EnergySource();
        windMolenPark.setId(2L);
        windMolenPark.setName("Windmolenpark");
        windMolenPark.setDescription("Een groep windturbines die windenergie " +
                "omzetten in elektriciteit");
        windMolenPark.setCategory(Constants.CATEGORY_ENERGY_PRODUCTION);
        windMolenPark.setImageUri("assets/photos/wind_park_2.png");
        windMolenPark.setEnergyProduction(750);
        windMolenPark.setEnvironmentalScore(-10);
        windMolenPark.setPopularityIncome(-10);
        return windMolenPark;
    }

    private EnergySource createWindParkOpZee() {
        EnergySource windParkOpZee = new EnergySource();
        windParkOpZee.setId(3L);
        windParkOpZee.setName("Windpark op zee");
        windParkOpZee.setDescription("Een groep windturbines in open water " +
                "die windenergie omzetten in elektriciteit");
        windParkOpZee.setCategory(Constants.CATEGORY_ENERGY_PRODUCTION);
        windParkOpZee.setImageUri("assets/photos/windpark_op_zee.png");
        windParkOpZee.setEnvironmentalScore(0);
        windParkOpZee.setEnergyProduction(1150);
        return windParkOpZee;
    }
}
