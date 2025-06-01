package com.dillian.energymanagement.bootstrap.adjacency;

import com.dillian.energymanagement.dtos.AdjacencySet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Industrial {

    public List<AdjacencySet> createIndustrialSets() {
        AdjacencySet industrialSet1 = new AdjacencySet(
                "Kantoorcomplex",
                "Parkeergarage",
                "goldIncome",
                +5,
                false,
                true
        );
        AdjacencySet industrialSet2 = new AdjacencySet(
                "Kantoorcomplex",
                "Gemeentehuis",
                "goldIncome",
                +5,
                false,
                true
        );

        AdjacencySet industrialSet3 = new AdjacencySet(
                "Kantoorcomplex",
                "Kantoorcomplex",
                "goldIncome",
                +5,
                false,
                false
        );
        AdjacencySet industrialSet4 = new AdjacencySet(
                "Gemeentehuis",
                "Parkeergarage",
                "goldIncome",
                +5,
                false,
                true
        );
        AdjacencySet industrialSet5 = new AdjacencySet(
                "Parkeergarage",
                "Pretpark",
                "goldIncome",
                +10,
                false,
                false
        );
        AdjacencySet industrialSet6 = new AdjacencySet(
                "Parkeergarage",
                "Aquapark",
                "goldIncome",
                +10,
                false,
                false
        );
        AdjacencySet industrialSet7 = new AdjacencySet(
                "Parkeergarage",
                "Snow World",
                "goldIncome",
                +10,
                false,
                false
        );
        AdjacencySet industrialSet8 = new AdjacencySet(
                "Parkeergarage",
                "Shopping Resorty",
                "goldIncome",
                +10,
                false,
                false
        );
        return List.of(industrialSet1, industrialSet2, industrialSet3, industrialSet4, industrialSet5,
                industrialSet6, industrialSet7, industrialSet8);
    }
}
