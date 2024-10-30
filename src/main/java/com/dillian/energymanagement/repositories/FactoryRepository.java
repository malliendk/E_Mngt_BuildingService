package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.building.Factory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactoryRepository extends JpaRepository<Factory, Long> {}

