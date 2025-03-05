package com.dillian.energymanagement.bootstrap.building;

import com.dillian.energymanagement.Constants;
import com.dillian.energymanagement.entities.building.GridAsset;
import com.dillian.energymanagement.repositories.GridAssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GridAssetBootstrap {

    private GridAssetRepository gridAssetRepository;

    public void saveGridAssets() {
        final GridAsset transformatorHuisje = createTransformatorHuisje();
        final GridAsset middenspanningsStation = createMiddenspanningsStation();
        final GridAsset hoogspanningsStation = createHoogspanningsStation();
        final GridAsset hoogspanningsMast = createHoogspanningsMast();
        gridAssetRepository.saveAll(List.of(transformatorHuisje, middenspanningsStation, hoogspanningsStation, hoogspanningsMast));
    }

    private GridAsset createTransformatorHuisje() {
        GridAsset transformatorHuisje = new GridAsset();
        transformatorHuisje.setId(10L);
        transformatorHuisje.setName("Transformatorhuisje");
        transformatorHuisje.setDescription("Elektriciteitsvoorziening die hoogspanning omzet naar een lagere" +
                "spanning voor veilige distributie van elektriciteit");
        transformatorHuisje.setCategory(Constants.CATEGORY_GRID_ASSET);
        transformatorHuisje.setPrice(300);
        transformatorHuisje.setGridCapacity(500);
        return transformatorHuisje;
    }

    private GridAsset createMiddenspanningsStation() {
        GridAsset middenspanningsStation = new GridAsset();
        middenspanningsStation.setId(11L);
        middenspanningsStation.setName("Middenspanningsstation");
        middenspanningsStation.setDescription("Elektriciteitsvoorziening die hoogspanning " +
                "omzet naar middenspanning en de stroom verder verdeelt naar lokale netwerken");
        middenspanningsStation.setCategory(Constants.CATEGORY_GRID_ASSET);
        middenspanningsStation.setPrice(550);
        middenspanningsStation.setGridCapacity(1000);
        return middenspanningsStation;
    }

    private GridAsset createHoogspanningsStation() {
        GridAsset hoogspanningsStation = new GridAsset();
        hoogspanningsStation.setId(12L);
        hoogspanningsStation.setName("Hoogspanningsstation");
        hoogspanningsStation.setDescription("Schakel- en verdeelstation in het elektriciteitsnet " +
                "dat elektrische energie transformeert tussen verschillende hoogspanningsniveaus " +
                "en stroom verdeelt naar regionale netwerken.");
        hoogspanningsStation.setCategory(Constants.CATEGORY_GRID_ASSET);
        hoogspanningsStation.setPrice(1000);
        hoogspanningsStation.setGridCapacity(2000);
        return hoogspanningsStation;
    }

    private GridAsset createHoogspanningsMast() {
        GridAsset hoogspanningsMast = new GridAsset();
        hoogspanningsMast.setId(13L);
        hoogspanningsMast.setName("Hoogspanningsmast");
        hoogspanningsMast.setDescription("Grote metalen toren die gebruikt wordt om " +
                "hoogspanningsleidingen boven de grond te dragen en elektriciteit " +
                "over lange afstanden te transporteren.");
        hoogspanningsMast.setCategory(Constants.CATEGORY_GRID_ASSET);
        hoogspanningsMast.setPrice(2000);
        hoogspanningsMast.setGridCapacity(5000);
        return hoogspanningsMast;
    }
}
