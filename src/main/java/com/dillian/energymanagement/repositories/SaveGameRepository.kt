package com.dillian.energymanagement.repositories

import com.dillian.energymanagement.entities.SaveGame
import org.springframework.data.jpa.repository.JpaRepository


interface SaveGameRepository : JpaRepository<SaveGame, Long> {
}