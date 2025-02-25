package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.building.SpecialBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialBuildingsRepository extends JpaRepository<SpecialBuilding, Long> {
}
