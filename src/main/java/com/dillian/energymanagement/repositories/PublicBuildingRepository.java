package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.building.PublicBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicBuildingRepository extends JpaRepository<PublicBuilding, Long> {
}
