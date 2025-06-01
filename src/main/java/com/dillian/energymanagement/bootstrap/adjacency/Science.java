package com.dillian.energymanagement.bootstrap.adjacency;

import com.dillian.energymanagement.dtos.AdjacencySet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Science {

    public List<AdjacencySet> createScienceSets() {
        AdjacencySet scienceSet1 = new AdjacencySet(
                "Laboratorium",
                "Universiteit",
                "researchIncome",
                +30,
                false,
                true
        );
        AdjacencySet scienceSet2 = new AdjacencySet(
                "Universiteit",
                "Bibliotheek",
                "researchIncome",
                +20,
                false,
                true
        );
        AdjacencySet scienceSet3 = new AdjacencySet(
                "Laboratorium",
                "Bibliotheek",
                "researchIncome",
                +10,
                false,
                true
        );
        return List.of(scienceSet1, scienceSet2, scienceSet3);
    }
}
