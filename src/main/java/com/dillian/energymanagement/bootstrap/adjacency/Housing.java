package com.dillian.energymanagement.bootstrap.adjacency;

import com.dillian.energymanagement.dtos.AdjacencySet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Housing {

    public List<AdjacencySet> createHousingSets() {
        AdjacencySet housingSet1 = new AdjacencySet(
                "Vrijstaand huis",
                "Windmolenpark",
                "popularityIncome",
                -10,
                true,
                true
                );
        AdjacencySet housingSet2 = new AdjacencySet(
                "Vrijstaand huis",
                "Kolencentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet3 = new AdjacencySet(
                "Vrijstaand huis",
                "Gascentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet4 = new AdjacencySet(
                "Vrijstaand huis",
                "Windmolenpark",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet5 = new AdjacencySet(
                "Vrijstaand huis",
                "Hoogspanningsmast",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet6 = new AdjacencySet(
                "Vrijstaand huis",
                "Hoogspanningscentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet = new AdjacencySet(
                "Vrijstaand huis",
                "Industrieterrein",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet7 = new AdjacencySet(
                "Twee onder één kap",
                "Windmolenpark",
                "popularityIncome",
                -10,
                true,
                true
        );
        AdjacencySet housingSet8 = new AdjacencySet(
                "Twee onder één kap",
                "Kolencentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet9 = new AdjacencySet(
                "Twee onder één kap",
                "Gascentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet10 = new AdjacencySet(
                "Twee onder één kap",
                "Windmolenpark",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet11 = new AdjacencySet(
                "Twee onder één kap",
                "Hoogspanningsmast",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet12 = new AdjacencySet(
                "Twee onder één kap",
                "Hoogspanningscentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet20 = new AdjacencySet(
                "Twee onder één kap",
                "IndustrieTerrein",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet13 = new AdjacencySet(
                "Huizenrij",
                "Windmolenpark",
                "popularityIncome",
                -10,
                true,
                true
        );
        AdjacencySet housingSet14 = new AdjacencySet(
                "Huizenrij",
                "Kolencentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet15 = new AdjacencySet(
                "Huizenrij",
                "Gascentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet16 = new AdjacencySet(
                "Huizenrij",
                "Windmolenpark",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet17 = new AdjacencySet(
                "Huizenrij",
                "Hoogspanningsmast",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet18 = new AdjacencySet(
                "Huizenrij",
                "Hoogspanningscentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet100 = new AdjacencySet(
                "Huizenrij",
                "Industrieterrein",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet19 = new AdjacencySet(
                "Appartementencomplex",
                "Windmolenpark",
                "popularityIncome",
                -10,
                true,
                true
        );
        AdjacencySet housingSet202 = new AdjacencySet(
                "Appartementencomplex",
                "Kolencentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet21 = new AdjacencySet(
                "Appartementencomplex",
                "Gascentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet22 = new AdjacencySet(
                "Appartementencomplex",
                "Windmolenpark",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet23 = new AdjacencySet(
                "Appartementencomplex",
                "Hoogspanningsmast",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet24 = new AdjacencySet(
                "Appartementencomplex",
                "Hoogspanningscentrale",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet200 = new AdjacencySet(
                "Appartementencomplex",
                "Industrieterrein",
                "popularityIncome",
                -10,
                true,
                true);
        AdjacencySet housingSet300 = new AdjacencySet(
                "Appartementencomplex",
                "Parkeergarage",
                "popularityIncome",
                +5,
                false,
                true);
        return List.of(housingSet1, housingSet2, housingSet3, housingSet4, housingSet5, housingSet6, housingSet,
                housingSet7, housingSet8, housingSet9, housingSet10, housingSet11, housingSet12, housingSet20,
                housingSet13, housingSet14, housingSet15, housingSet16, housingSet17, housingSet18, housingSet100,
                housingSet19, housingSet202, housingSet21, housingSet22, housingSet23, housingSet24, housingSet200,
                housingSet300);
    }
}
