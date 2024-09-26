package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.GridAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridAssetRepository extends JpaRepository<GridAsset, Long> {
}