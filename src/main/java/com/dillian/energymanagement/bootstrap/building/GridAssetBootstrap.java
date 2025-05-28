package com.dillian.energymanagement.bootstrap.building;

import com.dillian.energymanagement.Constants;
import com.dillian.energymanagement.entities.building.Utility;
import com.dillian.energymanagement.repositories.GridAssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GridAssetBootstrap {

    private GridAssetRepository gridAssetRepository;

    public void saveGridAssets() {
        final Utility transformatorHuisje = createTransformatorHuisje();
        final Utility middenspanningsStation = createMiddenspanningsStation();
        final Utility hoogspanningsStation = createHoogspanningsStation();
        final Utility hoogspanningsMast = createHoogspanningsMast();
        gridAssetRepository.saveAll(List.of(transformatorHuisje, middenspanningsStation, hoogspanningsStation, hoogspanningsMast));
    }

    private Utility createTransformatorHuisje() {
        Utility transformatorHuisje = new Utility();
        transformatorHuisje.setId(10L);
        transformatorHuisje.setName("Transformatorhuisje");
        transformatorHuisje.setDescription("Elektriciteitsvoorziening die hoogspanning omzet naar een lagere" +
                "spanning voor veilige distributie van elektriciteit");
        transformatorHuisje.setCategory(Constants.CATEGORY_GRID_ASSET);
        transformatorHuisje.setPrice(300);
        transformatorHuisje.setGridCapacity(500);
        return transformatorHuisje;
    }

    private Utility createMiddenspanningsStation() {
        Utility middenspanningsStation = new Utility();
        middenspanningsStation.setId(11L);
        middenspanningsStation.setName("Middenspanningsstation");
        middenspanningsStation.setDescription("Elektriciteitsvoorziening die hoogspanning " +
                "omzet naar middenspanning en de stroom verder verdeelt naar lokale netwerken");
        middenspanningsStation.setCategory(Constants.CATEGORY_GRID_ASSET);
        middenspanningsStation.setPrice(550);
        middenspanningsStation.setGridCapacity(1000);
        return middenspanningsStation;
    }

    private Utility createHoogspanningsStation() {
        Utility hoogspanningsStation = new Utility();
        hoogspanningsStation.setId(12L);
        hoogspanningsStation.setName("Hoogspanningsstation");
        hoogspanningsStation.setDescription("Schakel- en verdeelstation in het elektriciteitsnet " +
                "dat elektrische energie transformeert tussen verschillende hoogspanningsniveaus " +
                "en stroom verdeelt naar regionale netwerken.");
        hoogspanningsStation.setImageUri("assets/photos/hoogspanningsstation-cut.jpg");
        hoogspanningsStation.setCategory(Constants.CATEGORY_GRID_ASSET);
        hoogspanningsStation.setPrice(1000);
        hoogspanningsStation.setGridCapacity(2000);
        return hoogspanningsStation;
    }

    private Utility createHoogspanningsMast() {
        Utility hoogspanningsMast = new Utility();
        hoogspanningsMast.setId(13L);
        hoogspanningsMast.setName("Hoogspanningsmast");
        hoogspanningsMast.setDescription("Grote metalen toren die gebruikt wordt om " +
                "hoogspanningsleidingen boven de grond te dragen en elektriciteit " +
                "over lange afstanden te transporteren.");
        hoogspanningsMast.setImageUri("assets/photos/hoogspanningsmast.jpg");
        hoogspanningsMast.setCategory(Constants.CATEGORY_GRID_ASSET);
        hoogspanningsMast.setPrice(2000);
        hoogspanningsMast.setGridCapacity(5000);
        return hoogspanningsMast;
    }
}
