package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingRepository extends JpaRepository<Housing, Long> {
}
