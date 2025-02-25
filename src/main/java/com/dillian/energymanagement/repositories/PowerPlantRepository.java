package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.building.PowerPlant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerPlantRepository extends JpaRepository<PowerPlant, Long> {}

