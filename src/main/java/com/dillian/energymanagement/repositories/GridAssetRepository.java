package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.building.Utility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridAssetRepository extends JpaRepository<Utility, Long> {
}
