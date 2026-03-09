package com.dillian.energymanagement.bootstrap.building;

import com.dillian.energymanagement.entities.building.Utility;
import com.dillian.energymanagement.repositories.GridAssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dillian.energymanagement.Constants.CATEGORY_GRID_ASSET;

@Service
@AllArgsConstructor
public class GridAssetBootstrap {

    private GridAssetRepository gridAssetRepository;

    public void saveGridAssets() {
        final Utility powerCables = createPowerLine();
        final Utility transformatorHuisje = createTransformatorHuisje();
        final Utility middenspanningsStation = createMiddenspanningsStation();
        final Utility hoogspanningsStation = createHoogspanningsStation();
//        final Utility hoogspanningsMast = createHoogspanningsMast();
        gridAssetRepository.saveAll(List.of(powerCables, transformatorHuisje, middenspanningsStation, hoogspanningsStation));
    }


    private Utility createTransformatorHuisje() {
        Utility transformatorHuisje = new Utility();
        transformatorHuisje.setId(10L);
        transformatorHuisje.setName("Distribution Substation");
        transformatorHuisje.setDescription("Elektriciteitsvoorziening die hoogspanning omzet naar een lagere" +
                "spanning voor veilige distributie van elektriciteit");
        transformatorHuisje.setImageUri("assets/photos/transformator_huisje.jpg");
        transformatorHuisje.setCategory(CATEGORY_GRID_ASSET);
        transformatorHuisje.setPrice(300);
        transformatorHuisje.setGridCapacity(500);
        transformatorHuisje.setCanBePurchased(true);
        return transformatorHuisje;
    }

    private Utility createMiddenspanningsStation() {
        Utility middenspanningsStation = new Utility();
        middenspanningsStation.setId(11L);
        middenspanningsStation.setName("Medium-Voltage Substation");
        middenspanningsStation.setDescription("Elektriciteitsvoorziening die hoogspanning " +
                "omzet naar middenspanning en de stroom verder verdeelt naar lokale netwerken");
        middenspanningsStation.setImageUri("assets/photos/middenspannings_station.jpg");
        middenspanningsStation.setCategory(CATEGORY_GRID_ASSET);
        middenspanningsStation.setPrice(550);
        middenspanningsStation.setGridCapacity(1000);
        middenspanningsStation.setCanBePurchased(true);
        return middenspanningsStation;
    }

    private Utility createHoogspanningsStation() {
        Utility hoogspanningsStation = new Utility();
        hoogspanningsStation.setId(12L);
        hoogspanningsStation.setName("High-Voltage Substation");
        hoogspanningsStation.setDescription("Schakel- en verdeelstation in het elektriciteitsnet " +
                "dat elektrische energie transformeert tussen verschillende hoogspanningsniveaus " +
                "en stroom verdeelt naar regionale netwerken.");
        hoogspanningsStation.setImageUri("assets/photos/hoogspanningsstation-cut.jpg");
        hoogspanningsStation.setCategory(CATEGORY_GRID_ASSET);
        hoogspanningsStation.setPrice(1000);
        hoogspanningsStation.setGridCapacity(2000);
        hoogspanningsStation.setCanBePurchased(true);
        return hoogspanningsStation;
    }

    private Utility createPowerLine() {
        Utility powerCables = new Utility();
        powerCables.setId(14L);
        powerCables.setName("Power Line");
        powerCables.setDescription("Power Cables");
        powerCables.setImageUri("assets/photos/power-lines.jpg");
        powerCables.setCategory(CATEGORY_GRID_ASSET);
        powerCables.setPrice(100);
        powerCables.setGridCapacity(150);
        powerCables.setCanBePurchased(true);
        return powerCables;
    }

//    private Utility createHoogspanningsMast() {
//        Utility hoogspanningsMast = new Utility();
//        hoogspanningsMast.setId(13L);
//        hoogspanningsMast.setName("Hoogspanningsmast");
//        hoogspanningsMast.setDescription("Grote metalen toren die gebruikt wordt om " +
//                "hoogspanningsleidingen boven de grond te dragen en elektriciteit " +
//                "over lange afstanden te transporteren.");
//        hoogspanningsMast.setImageUri("assets/photos/hoogspanningsmast.jpg");
//        hoogspanningsMast.setCategory(Constants.CATEGORY_GRID_ASSET);
//        hoogspanningsMast.setPrice(2000);
//        hoogspanningsMast.setGridCapacity(5000);
//        hoogspanningsMast.setCanBePurchased(true);
//        return hoogspanningsMast;
//    }
}
