package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupervisorBootstrap {

    private final SupervisorRepository repository;

    public void create() {
        Supervisor kaitoTanaka = new Supervisor();
        kaitoTanaka.setId(1L);
        kaitoTanaka.setName("Kaito Tanaka");
        kaitoTanaka.setImageUrl("/assets/photos/supervisor/kaito_tanaka.png");
        kaitoTanaka.setBiography("He's from Japan enzo");
        kaitoTanaka.setClassType("Politician");
        kaitoTanaka.setType("Smooth Talker");
        kaitoTanaka.setSpecialAbility("Final Stand");
        kaitoTanaka.setPerkGoldIncome(1);
        kaitoTanaka.setPerkGoldCost(0);
        kaitoTanaka.setPerkResearchIncome(0);
        kaitoTanaka.setPerkResearchCost(0);
        kaitoTanaka.setPerkPopularityIncome(1);
        kaitoTanaka.setPerkPopularityCost(2);
        kaitoTanaka.setPerkGridEfficiency(0);
        kaitoTanaka.setPerkGridResilience(0);
        Supervisor ameliaLupina = new Supervisor();
        ameliaLupina.setId(2L);
        ameliaLupina.setName("Amelia Lupina");
        ameliaLupina.setImageUrl("/assets/photos/supervisor/amelia_lupina.png");
        ameliaLupina.setBiography("Italian woman enzo");
        ameliaLupina.setClassType("Scientist");
        ameliaLupina.setType("Platinum Particle");
        ameliaLupina.setSpecialAbility("Quantum Leap");
        ameliaLupina.setPerkGoldIncome(0);
        ameliaLupina.setPerkGoldCost(0);
        ameliaLupina.setPerkResearchIncome(2);
        ameliaLupina.setPerkResearchCost(1);
        ameliaLupina.setPerkPopularityIncome(0);
        ameliaLupina.setPerkPopularityCost(0);
        ameliaLupina.setPerkGridEfficiency(0);
        ameliaLupina.setPerkGridResilience(1);
        repository.saveAll(List.of(kaitoTanaka, ameliaLupina));
    }
}
