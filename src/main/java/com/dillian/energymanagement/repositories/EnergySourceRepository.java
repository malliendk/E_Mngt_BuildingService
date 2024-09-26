package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.EnergySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergySourceRepository extends JpaRepository<EnergySource, Long> {
}
